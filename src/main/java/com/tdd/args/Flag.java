package com.tdd.args;

/**
 Created with IntelliJ IDEA.
 User: lai.yi
 Date: 2019-05-29
 Description: 对参数flag的封装
 **/
class Flag {
    String tag;
    String type;

    Flag(String definition) {
        this.tag = definition.split(":")[0];
        this.type = definition.split(":")[1];
    }
}
