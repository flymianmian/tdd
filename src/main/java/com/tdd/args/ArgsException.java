package com.tdd.args;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-30
 * Description: 参数异常类
 **/
class ArgsException extends Throwable {
    private String message;

    ArgsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
