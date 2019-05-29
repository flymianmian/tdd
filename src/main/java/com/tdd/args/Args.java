package com.tdd.args;

import java.util.ArrayList;
import java.util.List;

class Args {


    private List<Argument> arguments = new ArrayList<>();

    public Args(String[] arguments) {
        for (String a : arguments) {
            this.arguments.add(new Argument(a));
        }
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public Argument getArgument(String tag) {
        for (Argument argument : this.arguments) {
            if (argument.tag.equals(tag)) {
                return argument;
            }
        }
        return null;
    }
}
