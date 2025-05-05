package com.om.exeception;

public class NoEventFoundException extends RuntimeException {
    public NoEventFoundException(String message) {
        super(message);
    }
}
