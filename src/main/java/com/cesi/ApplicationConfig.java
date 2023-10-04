package com.cesi;

import com.cesi.ingredient.IngredientResource;
import com.cesi.process.ProcessResource;
import com.cesi.product.ProductResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(IngredientResource.class);
        classes.add(ProductResource.class);
        classes.add(ProcessResource.class);

        classes.add(ResponseLoggingInterceptor.class);

        return classes;
    }
}
