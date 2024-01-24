package com.example.controller.resource;

import com.example.controller.request.UrlRequest;
import com.example.controller.request.UrlResponse;
import com.example.service.ShortenerService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/shortener")
public class UrlShortenerResource {

    @Inject
    ShortenerService shortenerService;

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Transactional
    public UrlResponse shortenUrl(UrlRequest urlRequest) {
        return shortenerService.shortenUrl(urlRequest); // TODO return proper HTTP status
    }

}
