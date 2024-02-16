package com.example.service;

import com.example.controller.request.UrlRequest;
import com.example.controller.request.UrlResponse;
import com.example.entity.Url;
import com.example.exception.UrlNotFoundException;
import com.example.repository.UrlRepository;
import com.google.common.io.BaseEncoding;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.sql.Timestamp;
import java.time.Instant;

import static com.google.common.base.Charsets.US_ASCII;

@ApplicationScoped
public class ShortenerService {

    private final String HOSTNAME = "http://localhost:8080/v1/"; // TODO this should come from an environment variable

    @Inject
    UrlRepository urlRepository;

    private static final Logger LOG = Logger.getLogger(ShortenerService.class);

    public UrlResponse shortenUrl(UrlRequest urlRequest) {
        var existentUrl = urlRepository.findByLongUrl(urlRequest.longUrl());

        if(existentUrl.isPresent()){
            return new UrlResponse(existentUrl.get().getKey(), existentUrl.get().getLongUrl(), existentUrl.get().getShortUrl());
        }

        var shortenedKey = BaseEncoding.base64Url().encode(urlRequest.longUrl().getBytes(US_ASCII));

        if (shortenedKey.length() > 14) {
            shortenedKey = shortenedKey.substring(0, 14);
        }

        LOG.info(String.format("URL %s was shortened to %s", urlRequest.longUrl(), shortenedKey));

        var url = Url.builder()
                .shortUrl(HOSTNAME + shortenedKey)
                .longUrl(urlRequest.longUrl())
                .createdAt(Timestamp.from(Instant.now()))
                .updatedAt(Timestamp.from(Instant.now()))
                .key(shortenedKey).build();

        urlRepository.persist(url);

        return new UrlResponse(url.getKey(), url.getLongUrl(), url.getShortUrl());
    }

    public Url getLongUrlByKey(String key) {
        return urlRepository
                .findByKey(key)
                .orElseThrow(() -> new UrlNotFoundException("Url not found for key: " + key));
    }

}
