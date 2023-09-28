package com.cesi.process;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/process")
public class ProcessResource {

    Logger logger;
    ProcessService service;

    public ProcessResource(Logger logger, ProcessService service) {
        this.service = service;
        this.logger = logger;
    }

    @GET
    @RolesAllowed({"Production","Commerce","R&D"})
    public RestResponse<List<Process>> getAllProcesses() {
        List<Process> processes = service.findAllProcesses();
        logger.debug("Total number of processes: " + processes.size());
        return RestResponse.ok(processes);
    }

    @GET
    @Path("/{id}")
    public RestResponse<Process> getProcess(@PathParam("id") Long id) {
        Process process = service.findProcessById(id);
        if (process != null) {
            logger.debug("Found process: " + process);
            return RestResponse.ok(process);
        } else {
            logger.debug("No process found with id: " + id);
            return RestResponse.noContent();
        }
    }

    @POST
    public RestResponse<Void> createProcess(@Valid Process process, @Context UriInfo uriInfo) {
        process = service.createProcess(process);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(process.id));
        logger.debug("New process created with URI: " + builder.build().toString());
        return RestResponse.created(builder.build());
    }

    @PUT
    public RestResponse<Process> updateProcess(@Valid Process process) {
        process = service.updateProcess(process);
        logger.debug("Process updated with new value: " + process);
        return RestResponse.ok(process);
    }

    @DELETE
    @Path("/{id}")
    public RestResponse<Void> deleteProcess(@PathParam("id") Long id) {
        service.deleteProcess(id);
        logger.debug("Process deleted with id: " + id);
        return RestResponse.noContent();
    }
}
