package com.tdd.marsrover;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
class MapException extends Throwable{
    private String message;

    MapException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
