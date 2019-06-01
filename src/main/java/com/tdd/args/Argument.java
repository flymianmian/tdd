package com.tdd.args;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-30
 * Description: 对传入参数的封装
 **/
class Argument {

    String value;
    String tag;

    Argument(String definition) {
        String[] slice = definition.split(" ");
        this.tag = slice[0].replace("-", "");
        this.value = slice.length > 1 ? slice[1] : null;
    }

    boolean getBooleanValue() throws ArgsException {
        if (this.value == null) {
            return true;
        }
        if (this.value.equals("true")) {
            return true;
        }
        if (this.value.equals("false")) {
            return false;
        }
        throw new ArgsException(String.format("Invalid boolean value found: %s", this.value));
    }

    int getIntegerValue() throws ArgsException {
        if (this.value == null) {
            throw new ArgsException(String.format("No value found for integer argument: %s", this.tag));
        }
        try {
            return Integer.valueOf(this.value);
        } catch (NumberFormatException exception) {
            throw new ArgsException(String.format("Invalid integer value found: %s", this.value));
        }
    }

    String getStringValue() throws ArgsException {
        if (this.value == null) {
            throw new ArgsException(String.format("No value found for string argument: %s", this.tag));
        }
        return this.value;
    }
}
