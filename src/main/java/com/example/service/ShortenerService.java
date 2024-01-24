package com.example.service;

import com.example.controller.request.UrlRequest;
import com.example.controller.request.UrlResponse;
import com.example.entity.Url;
import com.example.repository.UrlRepository;
import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.sql.Timestamp;
import java.time.Instant;

import static com.google.common.base.Charsets.US_ASCII;

@ApplicationScoped
public class ShortenerService {

    @Inject
    UrlRepository urlRepository;

    private static final Logger LOG = Logger.getLogger(ShortenerService.class);

    public UrlResponse shortenUrl(UrlRequest urlRequest) {
        var shortenedKey = BaseEncoding.base64Url().encode(urlRequest.longUrl().getBytes(US_ASCII));

        if(shortenedKey.length() > 14){
            shortenedKey = shortenedKey.substring(0, 14);
        }

        LOG.info(String.format("URL %s was shortened to %s", urlRequest.longUrl(), shortenedKey));

        Url url = new Url();

        url.setLongUrl(urlRequest.longUrl());
        url.setCreatedAt(Timestamp.from(Instant.now()));
        url.setUpdatedAt(Timestamp.from(Instant.now()));
        url.setShortUrl(shortenedKey); // TODO it's wrong, need to concat the hostname
        url.setKey(shortenedKey);

        urlRepository.persist(url);

        return new UrlResponse(url.getKey(), url.getLongUrl(), url.getShortUrl());
    }

}
