package com.example.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record UrlRequest(

        @JsonProperty("long_url")
        @NotBlank(message = "URL most not be blank")
        String longUrl
) {
}
