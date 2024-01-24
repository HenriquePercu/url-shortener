package com.example.service;

import com.example.controller.request.UrlRequest;
import com.example.controller.request.UrlResponse;
import com.example.entity.Url;
import com.example.repository.UrlRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.Timestamp;
import java.time.Instant;

@ApplicationScoped
public class ShortenerService {

    @Inject
    UrlRepository urlRepository;

    public UrlResponse shortenUrl(UrlRequest urlRequest) {
        Url url = new Url();

        url.setLongUrl(urlRequest.longUrl());
        url.setCreatedAt(Timestamp.from(Instant.now()));
        url.setUpdatedAt(Timestamp.from(Instant.now()));
        url.setShortUrl("short_url");
        url.setKey("1212");

        urlRepository.persist(url);

        return new UrlResponse(url.getKey(), url.getLongUrl(), url.getShortUrl());
    }

}
