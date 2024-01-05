package com.example;

import com.example.repository.UrlRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    UrlRepository urlRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Long hello() {

        return urlRepository.count();
    }
}
