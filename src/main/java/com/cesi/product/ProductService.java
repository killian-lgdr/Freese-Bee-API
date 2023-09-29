package com.cesi.product;

import com.cesi.process.Process;
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
        if (entity != null) {
            // Supprimer toutes les occurrences de ProductIngredient associées à ce Product
            ProductIngredient.delete("product = ?1", entity);

            // Mettre à jour les propriétés du Product
            entity.nom = product.nom;
            entity.description = product.description;
            entity.pUHT = product.pUHT;
            entity.gamme = product.gamme;

            // Assurez-vous que les références sont correctement établies
            for (ProductIngredient productIngredient : product.productIngredients) {
                productIngredient.product = entity;
            }

            // Enregistrez les modifications
            entity.persist();
        }
        return entity;
    }

    public void deleteProduct(Long id) {
        Product product = Product.findById(id);
        if (product != null) {
            Process.delete("product = ?1", product);
            for (ProductIngredient productIngredient : product.productIngredients) {
                productIngredient.delete();
            }
            product.delete();
        }
    }
}
