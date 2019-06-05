package com.tdd.args;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-30
 * Description: 参数解析器
 **/
class Parser {
    private Schema schema;
    private Args args;

    Parser(Schema schema, Args args) {
        this.schema = schema;
        this.args = args;
    }

    Object getValue(String tag) throws ArgsException {
        Flag flag = this.schema.getFlag(tag);
        if (null == flag) {
            throw new ArgsException(String.format("Invalid argument tag found: %s", tag));
        }
        Argument argument = this.args.getArgument(tag);
        switch (flag.type) {
            case "boolean":
                return argument != null && argument.getBooleanValue();
            case "integer":
                return argument == null ? 0 : argument.getIntegerValue();
            case "string":
                return argument == null ? "" : argument.getStringValue();
            case "array":
                return argument == null ? new String[]{}:argument.getArrayValue();
            default:
                throw new ArgsException(String.format("Invalid argument type found: %s", flag.type));
        }
    }
}
