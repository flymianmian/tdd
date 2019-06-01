package com.tdd.args;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-30
 * Description: 定义参数用的schema
 **/
class Schema {
    private List<Flag> flags;

    Schema(String[] definition) {
        this.flags = Arrays.stream(definition).map(Flag::new).collect(Collectors.toList());
    }

    List<Flag> getFlags() {
        return this.flags;
    }

    boolean hasFlag(String tag) {
        return this.flags.stream().anyMatch(flag -> flag.tag.equals(tag));
    }

    Flag getFlag(String tag) {
        return this.flags.stream().filter(flag -> flag.tag.equals(tag)).findAny().orElse(null);
    }
}
