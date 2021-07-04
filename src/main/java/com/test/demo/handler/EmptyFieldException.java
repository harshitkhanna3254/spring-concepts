package com.test.demo.handler;

public class EmptyFieldException extends RuntimeException {

    private String message;

    public EmptyFieldException(String message) {
        this.setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
