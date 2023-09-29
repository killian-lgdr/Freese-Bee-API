package com.cesi.ingredient;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/ingredient")
//@RolesAllowed({"R&D"})
public class IngredientResource {

    Logger logger;
    IngredientService service;

    public IngredientResource(Logger logger, IngredientService service) {
        this.service = service;
        this.logger = logger;
    }
    @GET
    public RestResponse<List<Ingredient>> getAllIngredient() {
        List<Ingredient> ingredients = service.findAllIngredients();
        logger.debug("Total number of ingredients " + ingredients.size());
        return RestResponse.ok(ingredients);
    }

    @GET
    @Path("/{id}")
    public RestResponse<Ingredient> getIngredient(@RestPath Long id) {
        Ingredient villain = service.findIngredientById(id);
        if (villain != null) {
            logger.debug("Found ingredient " + villain);
            return RestResponse.ok(villain);
        } else {
            logger.debug("No ingredient found with id " + id);
            return RestResponse.noContent();
        }
    }

    @POST
    public RestResponse<Void> createIngredient(@Valid Ingredient ingredient, @Context UriInfo uriInfo) {
        ingredient = service.persistIngredient(ingredient);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(ingredient.id));
        logger.debug("New ingredient created with URI " + builder.build().toString());
        return RestResponse.created(builder.build());
    }

    @PUT
    public RestResponse<Ingredient> updateIngredient(@Valid Ingredient ingredient) {
        ingredient = service.updateIngredient(ingredient);
        logger.debug("Ingredient updated with new valued " + ingredient);
        return RestResponse.ok(ingredient);
    }

    @DELETE
    @Path("/{id}")
    public RestResponse<Void> deleteIngredient(@RestPath Long id) {
        service.deleteIngredient(id);
        logger.debug("Ingredient deleted with " + id);
        return RestResponse.noContent();
    }
}
