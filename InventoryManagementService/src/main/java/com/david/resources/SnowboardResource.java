package com.david.resources;

import com.david.models.snowboard.ImmutableNewSnowboardRequestIF;
import com.david.models.snowboard.ImmutableSnowboardIF;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/snowboards")
@Produces(MediaType.APPLICATION_JSON)
public class SnowboardResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public SnowboardResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @POST
    public void createSnowboard(ImmutableNewSnowboardRequestIF newSnowboardRequestIF) {

    }

    @Path("/v1/{snowboardId}")
    @DELETE
    public void deleteSnowboard(@PathParam("snowboardId") Long snowboardId) {

    }

    @Path("/v1/{snowboardId}")
    @GET
    public Optional<ImmutableSnowboardIF> getSnowboard(@PathParam("snowboardId") Long snowboardId) {
        return Optional.of(ImmutableSnowboardIF.builder()
                .snowboardId(0).color("green")
                .isSymmetrical(false)
                .snowboardLength(100).build());
    }
}