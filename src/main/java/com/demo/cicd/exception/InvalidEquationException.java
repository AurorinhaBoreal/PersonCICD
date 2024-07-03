package com.demo.cicd.exception;

public class InvalidEquationException extends RuntimeException {
    public InvalidEquationException(String message) {
        super(message);
    }
}
