package com.example.marketplace.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private final ErrorCodes errorCode;

    public EntityNotFoundException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}