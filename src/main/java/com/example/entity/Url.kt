package com.example.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.sql.Timestamp
import java.time.LocalDateTime

@Entity
class Url : PanacheEntity() {

    @Id
    @GeneratedValue
    override var id: Long? = null;
    lateinit var shortUrl: String
    lateinit var longUrl: String
    lateinit var createdAt: Timestamp
    lateinit var updatedAt: Timestamp

}