package com.tdd.args;

import java.util.Objects;

class Parser {
    private final Args args;
    private Schema schema;

    Parser(Schema schema, Args args) {
        this.schema = schema;
        this.args = args;
    }

    Object getValue(String tag) throws ArgsException {
        if (this.schema.containFlag(tag)) {
            Flag flag = this.schema.getFlag(tag);
            Argument argument = this.args.getArgument(tag);
            switch (flag.type) {
                case "boolean":
                    if (null == argument || null == argument.value) {
                        return false;
                    }
                    if (argument.value.equals("true")) {
                        return true;
                    }
                    if (argument.value.equals("false")) {
                        return false;
                    }
                    throw new ArgsException(String.format("Invalid value for argument %s, expect true/false got %s", argument.tag, argument.value));
                case "integer":
                    if (null == argument.value) {
                        return 0;
                    }
                    try {
                        return Integer.parseInt(argument.value);
                    } catch (NumberFormatException exception) {
                        throw new ArgsException(String.format("Invalid value for argument %s, expect integer value got %s", argument.tag, argument.value));
                    }
                case "string":
                    return Objects.requireNonNullElse(argument.value, "");
                default:
                    throw new ArgsException(String.format("unknown value type: %s", flag.type));
            }
        } else {
            throw new ArgsException(String.format("can not find any argument with tag: %s", tag));
        }
    }
}
