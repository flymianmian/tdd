package com.tdd.args;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-29
 * Description: 参数解析器
 **/
class Parser {
    private final Args args;
    private Schema schema;

    Parser(Schema schema, Args args) {
        this.schema = schema;
        this.args = args;
    }

    /**
     * 获取解析出的参数
     *
     * @param tag 参数的标签用于匹配schema中的定义
     * @return 对应的参数值
     * @throws ArgsException 参数异常
     */
    Object getValue(String tag) throws ArgsException {
        if (this.schema.containFlag(tag)) {
            Flag flag = this.schema.getFlag(tag);
            Argument argument = this.args.getArgument(tag);
            switch (flag.type) {
                // 布尔类型参数
                case "boolean":
                    return getBooleanValue(argument);
                // 整型参数
                case "integer":
                    return getIntegerValue(argument);
                // 字符串类型参数
                case "string":
                    return getStringValue(argument);
                // 未知类型参数
                default:
                    throw new ArgsException(String.format("unknown value type: %s", flag.type));
            }
        }
        // schema中没有定义过的tag
        throw new ArgsException(String.format("can not find any argument with tag: %s", tag));
    }

    private String getStringValue(Argument argument) {
        return Objects.requireNonNullElse(argument.value, "");
    }

    private Integer getIntegerValue(Argument argument) throws ArgsException {
        if (null == argument.value) {
            return 0;
        }
        try {
            return Integer.parseInt(argument.value);
        } catch (NumberFormatException exception) {
            throw new ArgsException(String.format("Invalid value for argument %s, expect integer value got %s", argument.tag, argument.value));
        }
    }

    private Boolean getBooleanValue(Argument argument) throws ArgsException {
        if (null == argument) {
            return false;
        }
        if (null == argument.value || argument.value.equals("true")) {
            return true;
        }
        if (argument.value.equals("false")) {
            return false;
        }
        throw new ArgsException(String.format("Invalid value for argument %s, expect true/false got %s", argument.tag, argument.value));
    }
}
