package com.example;

import com.example.repository.UrlRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/hello")
public class ExampleResource {

    @Inject
    UrlRepository urlRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Tag(ref = "url")
    public Long hello() {

        return urlRepository.count();
    }
}
