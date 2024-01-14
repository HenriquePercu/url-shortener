package com.example.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UrlResponse(
        String key,
        @JsonProperty("long_url")
        String longUrl,
        @JsonProperty("short_url")
        String shortUrl
) {

}
