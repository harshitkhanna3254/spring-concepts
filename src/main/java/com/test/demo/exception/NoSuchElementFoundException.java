package com.test.demo.exception;

public class NoSuchElementFoundException extends RuntimeException{
    public NoSuchElementFoundException(String message) {
        super(message);
    }
}
