package com.cesi;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class ResponseLoggingInterceptor implements ContainerResponseFilter {
    private static final Logger logger = Logger.getLogger(ResponseLoggingInterceptor.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        int status = responseContext.getStatus();

        logger.info("Method: " + method + ", Path : " + path + ", Response Status: " + status);
    }
}
