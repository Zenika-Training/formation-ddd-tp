package com.zenika.ddd.shared;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
