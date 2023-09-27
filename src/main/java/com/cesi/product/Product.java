package com.cesi.product;

import com.cesi.ProductIngredient;
import com.cesi.ingredient.Ingredient;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
public class Product extends PanacheEntity {

    @NotNull
    @Size(min = 3, max = 100)
    public String nom;

    @NotNull
    public String description;

    @NotNull
    public String pUHT;

    @NotNull
    public String gamme;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    public List<ProductIngredient> productIngredients;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pUHT='" + pUHT + '\'' +
                ", gamme='" + gamme + '\'' +
                ", productIngredients='" + productIngredients.toString() + '\'' +
                '}';
    }
}
