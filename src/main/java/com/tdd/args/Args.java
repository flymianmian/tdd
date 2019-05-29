package com.tdd.args;

import java.util.ArrayList;
import java.util.List;

/**
 Created with IntelliJ IDEA.
 User: lai.yi
 Date: 2019-05-29
 Description: 对传入参数的封装
 **/
class Args {

    private List<Argument> arguments = new ArrayList<>();

    Args(String[] arguments) {
        for (String a : arguments) {
            this.arguments.add(new Argument(a));
        }
    }

    List<Argument> getArguments() {
        return arguments;
    }

    Argument getArgument(String tag) {
        for (Argument argument : this.arguments) {
            if (argument.tag.equals(tag)) {
                return argument;
            }
        }
        return null;
    }
}
