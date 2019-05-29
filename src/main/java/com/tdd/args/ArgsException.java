package com.tdd.args;

public class ArgsException extends Throwable {
    private final String message;

    public ArgsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
