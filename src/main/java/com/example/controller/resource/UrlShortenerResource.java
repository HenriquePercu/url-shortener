package com.example.controller.resource;

import com.example.controller.request.UrlRequest;
import com.example.controller.request.UrlResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/shortener")
public class UrlShortenerResource {

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public UrlResponse shortenUrl(UrlRequest urlRequest) {
        return new UrlResponse("12", "1212", "1212");
    }

}
