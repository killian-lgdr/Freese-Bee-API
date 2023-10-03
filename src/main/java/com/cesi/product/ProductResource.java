package com.cesi.product;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/product")
public class ProductResource {

    Logger logger;
    ProductService service;


    public ProductResource(Logger logger, ProductService service) {
        this.service = service;
        this.logger = logger;
    }

    @GET
    @RolesAllowed({"R&D", "Production", "Commerce"})
    public RestResponse<List<Product>> getAllProducts() {
        List<Product> products = service.findAllProducts();
        logger.debug("Total number of products: " + products.size());
        return RestResponse.ok(products);
    }

    @GET
    @RolesAllowed({"R&D", "Production", "Commerce"})
    @Path("/{id}")
    public RestResponse<Product> getProduct(@PathParam("id") Long id) {
        Product product = service.findProductById(id);
        if (product != null) {
            logger.debug("Found product: " + product);
            return RestResponse.ok(product);
        } else {
            logger.debug("No product found with id: " + id);
            return RestResponse.noContent();
        }
    }

    @POST
    @RolesAllowed({"R&D"})
    public RestResponse<Void> createProduct(@Valid Product product, @Context UriInfo uriInfo) {
        product = service.createProduct(product);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(product.id));
        logger.debug("New product created with URI: " + builder.build().toString());
        return RestResponse.created(builder.build());
    }

    @PUT
    @RolesAllowed({"R&D"})
    public RestResponse<Product> updateProduct(@Valid Product product) {
        product = service.updateProduct(product);
        logger.debug("Product updated with new value: " + product);
        return RestResponse.ok(product);
    }

    @DELETE
    @RolesAllowed({"R&D"})
    @Path("/{id}")
    public RestResponse<Void> deleteProduct(@PathParam("id") Long id) {
        service.deleteProduct(id);
        logger.debug("Product deleted with id: " + id);
        return RestResponse.noContent();
    }
}