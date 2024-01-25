package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity(name = "URL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Url {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false, name = "short_url")
    private String shortUrl;

    @Column(nullable = false, name = "long_url")
    private String longUrl;

    @Column(nullable = false, name = "created_at")
    private Timestamp createdAt;

    @Column(nullable = false, name = "updated_at")
    private Timestamp updatedAt;
}
