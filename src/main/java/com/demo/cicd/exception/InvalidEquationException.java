/**
 * This package contains classes related to the demo application.
 */
package com.demo.cicd.exception;

public class InvalidEquationException extends RuntimeException {
    public InvalidEquationException(final String message) {
        super(message);
    }
}
