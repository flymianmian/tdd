package com.tdd.args;

/**
 Created with IntelliJ IDEA.
 User: lai.yi
 Date: 2019-05-29
 Description: 对传入参数的封装
 **/
class Argument {

    String tag;
    String value;

    Argument(String definition) {
        String[] splitTexts = definition.split(" ");
        this.tag = splitTexts[0].replace("-", "");
        if (splitTexts.length > 1) {
            this.value = splitTexts[1];
        }
    }
}
