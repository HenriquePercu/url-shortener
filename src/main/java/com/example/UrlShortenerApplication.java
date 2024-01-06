package com.example;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@OpenAPIDefinition(
        tags = {
                @Tag(name="url", description="Url Shortener operations."),
        },
        info = @Info(
                title="Example API",
                version = "1.0.1",
                contact = @Contact(
                        name = "Url Shortener API Specification",
                        url = "http://exampleurl.com/contact",
                        email = "techsupport@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class UrlShortenerApplication extends Application {
}
