package com.tdd.args;

import java.util.ArrayList;
import java.util.List;

/**
 Created with IntelliJ IDEA.
 User: lai.yi
 Date: 2019-05-29
 Description: 定义参数用的schema
 **/
class Schema {
    private List<Flag> flags = new ArrayList<>();

    Schema(String[] definition) {
        for (String d : definition) {
            this.flags.add(new Flag(d));
        }
    }

    List<Flag> getFlags() {
        return flags;
    }

    boolean containFlag(String tag) {
        for (Flag flag : this.flags) {
            if (flag.tag.equals(tag)) {
                return true;
            }
        }
        return false;
    }

    Flag getFlag(String tag) {
        for (Flag flag : this.flags) {
            if (flag.tag.equals(tag)) {
                return flag;
            }
        }
        return null;
    }
}
