package com.cesi.process;

import com.cesi.product.Product;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Process extends PanacheEntity {

    @NotNull
    @Size(min = 3, max = 100)
    public String nom;

    @NotNull
    public String description;

    @ManyToOne
    @NotNull
    public Product product;
    @NotNull
    public String commentaire;

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", product='" + product.toString() + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
