package com.tdd.args;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-30
 * Description: 封装整个参数列表
 **/
class Args {
    private List<Argument> arguments;

    Args(String[] definition) {
        this.arguments = Arrays.stream(definition)
                .map(Argument::new)
                .collect(Collectors.toList());
    }

    List<Argument> getArguments() {
        return this.arguments;
    }

    Argument getArgument(String tag) {
        return this.arguments.stream()
                .filter(argument -> argument.tag.equals(tag))
                .findAny()
                .orElse(null);
    }
}
