package com.tdd.args;

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
