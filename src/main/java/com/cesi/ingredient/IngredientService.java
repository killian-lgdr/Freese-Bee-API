package com.cesi.ingredient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class IngredientService {
    @Transactional(SUPPORTS)
    public List<Ingredient> findAllIngredients() {
        return Ingredient.listAll();
    }

    @Transactional(SUPPORTS)
    public Ingredient findIngredientById(Long id) {
        return Ingredient.findById(id);
    }

    public Ingredient persistIngredient(@Valid Ingredient ingredient) {
        ingredient.persist();
        return ingredient;
    }

    public Ingredient updateIngredient(@Valid Ingredient ingredient) {
        Ingredient entity = Ingredient.findById(ingredient.id);
        entity.nom = ingredient.nom;
        entity.description = ingredient.description;
        return entity;
    }

    public void deleteIngredient(Long id) {
        Ingredient ingredient = Ingredient.findById(id);
        ingredient.delete();
    }
}