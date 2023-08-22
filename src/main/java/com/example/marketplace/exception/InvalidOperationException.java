package com.example.marketplace.exception;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException{

    @Getter
    private ErrorCodes errorCode;

    public InvalidOperationException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}