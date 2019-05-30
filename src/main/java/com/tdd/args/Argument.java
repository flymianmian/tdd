package com.tdd.args;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-29
 * Description: 对传入参数的封装
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

    Boolean getBooleanValue() throws ArgsException {
        if (null == value || value.equals("false")) {
            return false;
        }
        if (value.equals("true")) {
            return true;
        }
        throw new ArgsException(String.format("Invalid value for argument %s, expect true/false got %s", tag, value));
    }

    Integer getIntegerValue() throws ArgsException {
        if (null == value) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new ArgsException(String.format("Invalid value for argument %s, expect integer value got %s", tag, value));
        }
    }

    String getStringValue() {
        return Objects.requireNonNullElse(value, "");
    }
}
