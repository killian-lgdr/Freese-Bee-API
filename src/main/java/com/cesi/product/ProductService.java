package com.cesi.product;

import com.cesi.ProductIngredient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class ProductService {

    @Transactional(SUPPORTS)
    public List<Product> findAllProducts() {
        return Product.listAll();
    }

    @Transactional(SUPPORTS)
    public Product findProductById(Long id) {
        return Product.findById(id);
    }

    public Product createProduct(@Valid Product product) {
        for (ProductIngredient productIngredient : product.productIngredients) {
            productIngredient.product = product;
        }
        product.persist();
        return product;
    }

    public Product updateProduct(@Valid Product product) {
        Product entity = Product.findById(product.id);
        entity.nom = product.nom;
        entity.description = product.description;
        entity.pUHT = product.pUHT;
        entity.gamme = product.gamme;

        entity.productIngredients = product.productIngredients;
        return entity;
    }

    public void deleteProduct(Long id) {
        Product product = Product.findById(id);
        product.delete();
    }
}
