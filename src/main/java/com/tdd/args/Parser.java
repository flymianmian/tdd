package com.tdd.args;

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
                    return argument == null ? false : argument.getBooleanValue();
                // 整型参数
                case "integer":
                    return argument == null ? 0 : argument.getIntegerValue();
                // 字符串类型参数
                case "string":
                    return argument == null ? "" : argument.getStringValue();
                // 未知类型参数
                default:
                    throw new ArgsException(String.format("Unknown value type: %s", flag.type));
            }
        }
        // schema中没有定义过的tag
        throw new ArgsException(String.format("Can not find any argument with tag: %s", tag));
    }

}
