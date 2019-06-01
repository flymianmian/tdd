package com.tdd.args;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-30
 * Description: 对参数flag的封装
 **/
public class Flag {
    public String type;
    public String tag;

    public Flag(String definition) {
        this.tag = definition.split(":")[0];
        this.type = definition.split(":")[1];
    }
}
