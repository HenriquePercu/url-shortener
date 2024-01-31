package com.example.controller.exception;

public record ErrorResponse(
        String type,
        String title,
        String detail

) {

}