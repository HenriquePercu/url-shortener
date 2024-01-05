package com.example.repository;

import com.example.entity.Url;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UrlRepository implements PanacheRepository<Url> {


}
