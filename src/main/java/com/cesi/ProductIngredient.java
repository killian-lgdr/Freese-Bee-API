package com.cesi;

import com.cesi.ingredient.Ingredient;
import com.cesi.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProductIngredient extends PanacheEntity {

    @ManyToOne
    @JsonIgnore
    public Product product;

    @ManyToOne
    public Ingredient ingredient;

    @NotNull
    public int grammage;

    @Override
    public String toString() {
        return "ProductIngredient{" +
                "id=" + id +
                ", Ingredient='" + ingredient.toString() + '\'' +
                ", grammage='" + grammage + '\'' +
                '}';
    }
}
