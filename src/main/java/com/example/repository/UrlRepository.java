package com.example.repository;

import com.example.entity.Url;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UrlRepository implements PanacheRepository<Url> {

    public Optional<Url> findByKey(String key) {
        return find("key", key).firstResultOptional();
    }

    public Optional<Url> findByLongUrl(String longUrl) {
        return find("longUrl", longUrl).firstResultOptional();
    }

}
