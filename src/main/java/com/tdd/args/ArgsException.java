package com.tdd.args;

/**
 Created with IntelliJ IDEA.
 User: lai.yi
 Date: 2019-05-29
 Description:
 **/
public class ArgsException extends Throwable {
    private final String message;

    ArgsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
