package com.example.controller.resource;

import com.example.controller.request.UrlRequest;
import com.example.controller.request.UrlResponse;
import com.example.service.ShortenerService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Path("/v1")
public class UrlShortenerResource {

    @Inject
    ShortenerService shortenerService;

    @POST
    @Path("/shortener")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Transactional
    public RestResponse<UrlResponse> shortenUrl(@Valid UrlRequest urlRequest) {
        return ResponseBuilder
                .ok(shortenerService.shortenUrl(urlRequest))
                .build();
    }

    @GET
    @Path("/{key}")
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public RestResponse<Object> redirectToLongUrl(@PathParam("key") String key) throws URISyntaxException {
        return ResponseBuilder
                .create(Response.Status.FOUND)
                .location(new URI(shortenerService.getLongUrlByKey(key).getLongUrl()))
                .build();
    }

    @DELETE
    @Path("/{key}")
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public RestResponse<Object> deleteUrlByKey(@PathParam("key") String key) throws URISyntaxException {
        shortenerService.deleteUrlByKey(key);

        return ResponseBuilder
                .noContent()
                .build();
    }
}
