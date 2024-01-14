package com.example.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UrlRequest(
        @JsonProperty("long_url")
        String longUrl
) {
}
