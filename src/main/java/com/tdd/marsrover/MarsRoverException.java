package com.tdd.marsrover;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
class MarsRoverException extends Throwable{
    private String message;

    MarsRoverException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
