package com.tdd.args;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
    private Schema schema = new Schema(new String[]{"l:boolean", "p:integer", "d:string"});

    /**
     * 布尔值参数测试
     */
    @Test
    void should_return_true_when_given_empty_value() throws ArgsException {
        Args args = new Args(new String[]{"-l", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }

    @Test
    void should_return_false_when_not_given_value() throws ArgsException {
        Args args = new Args(new String[]{"-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    void should_return_true_when_given_true_value() throws ArgsException {
        Args args = new Args(new String[]{"-l true", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }

    @Test
    void should_return_false_when_given_false_value() throws ArgsException {
        Args args = new Args(new String[]{"-l false", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    void should_throw_exception_when_given_invalid_boolean_value() {
        Args args = new Args(new String[]{"-l 123", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("l"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Invalid value for argument l, expect true/false got 123");
    }

    /**
     * 整数参数测试
     */
    @Test
    void should_return_integer_when_given_integer_tag() throws ArgsException {
        Args args = new Args(new String[]{"-l", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("p")).isEqualTo(1080);
    }

    @Test
    void should_throw_exception_when_given_empty_integer_tag() {
        Args args = new Args(new String[]{"-l", "-p", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("p"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Missing value part of integer argument: p");
    }

    @Test
    void should_throw_exception_when_given_invalid_integer_value() {
        Args args = new Args(new String[]{"-l", "-p abc", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("p"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Invalid value for argument p, expect integer value got abc");
    }

    /**
     * 字符串参数测试
     */
    @Test
    void should_return_string_when_given_string_tag() throws ArgsException {
        Args args = new Args(new String[]{"-l", "-p", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("d")).isEqualTo("/usr/logs");
    }

    @Test
    void should_return_default_value_when_not_given_string_tag() throws ArgsException {
        Args args = new Args(new String[]{"-l", "-p 1080"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("d")).isEqualTo("");
    }

    @Test
    void should_throw_exception_when_given_string_tag_without_value() {
        Args args = new Args(new String[]{"-l", "-p 1080", "-d"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("d"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Missing value part of string argument: d");
    }

    /**
     * 异常参数测试
     */
    @Test
    void should_throw_exception_when_given_unknown_tag() {
        Args args = new Args(new String[]{"-l", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("g"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Can not find any argument with tag: g");
    }

    @Test
    void should_throw_exception_when_given_unknown_value_type() {
        Schema schema = new Schema(new String[]{"a:array"});
        Args args = new Args(new String[]{"-a this,is,an,array"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("a"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Unknown value type: array");
    }
}
