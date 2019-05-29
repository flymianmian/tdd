package com.tdd.args;

class Flag {
    String tag;
    String type;

    Flag(String definition) {
        this.tag = definition.split(":")[0];
        this.type = definition.split(":")[1];
    }
}
