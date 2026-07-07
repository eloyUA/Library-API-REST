package com.example.library.books.domain.dto;

import java.time.LocalDateTime;

public class ErrorResponseDto {
    private final Integer status;
    private final String error;
    private final String message;
    private final LocalDateTime timestamp;

    public ErrorResponseDto(ErrorResponseDto errorResponse) {
        this.status = errorResponse.getStatus();
        this.error = errorResponse.getError();
        this.message = errorResponse.getMessage();
        this.timestamp = errorResponse.getTimestamp();
    }

    public ErrorResponseDto(Integer status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
