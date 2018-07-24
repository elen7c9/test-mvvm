package com.dz.elen.domain.entity;

public class Error extends Exception {

    private ErrorType type;

    public Error(String message, ErrorType type) {
        super(message);
        this.type = type;
    }

    public ErrorType getType() {
        return type;
    }
}
