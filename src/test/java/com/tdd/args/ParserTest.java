package com.tdd.args;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
    private Schema schema = new Schema(new String[]{"l:boolean", "p:integer", "d:string"});

    @Test
    void shouldReturnDefaultValueWhenGivenEmptyBooleanTag() throws ArgsException {
        Args args = new Args(new String[]{"-l", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    void shouldReturnFalseWhenNotGivenBooleanTag() throws ArgsException {
        Args args = new Args(new String[]{"-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    void shouldReturnFalseWhenGivenFalseValue() throws ArgsException {
        Args args = new Args(new String[]{"-l false", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    void shouldReturnTrueWhenGivenTrueValue() throws ArgsException {
        Args args = new Args(new String[]{"-l true", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }

    @Test
    void shouldThrowExceptionWhenGivenInvalidBooleanValue() {
        Args args = new Args(new String[]{"-l 123", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("l"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Invalid value for argument l, expect true/false got 123");
    }

    @Test
    void shouldReturnIntegerWhenGivenIntegerTag() throws ArgsException {
        Args args = new Args(new String[]{"-l", "-p 1080", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("p")).isEqualTo(1080);
    }

    @Test
    void shouldReturnDefaultIntegerWhenGivenEmptyIntegerTag() throws ArgsException {
        Args args = new Args(new String[]{"-l", "-p", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("p")).isEqualTo(0);
    }

    @Test
    void shouldThrowExceptionWhenGivenInvalidIntegerValue() {
        Args args = new Args(new String[]{"-l", "-p abc", "-d /usr/logs"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("p"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Invalid value for argument p, expect integer value got abc");
    }

    @Test
    void shouldReturnStringWhenGivenStringTag() throws ArgsException {
        Args args = new Args(new String[]{"-l", "-p", "-d /usr/logs"});
        Parser parser = new Parser(schema,args);
        assertThat(parser.getValue("d")).isEqualTo("/usr/logs");
    }

    @Test
    void shouldReturnDefaultValueWhenGivenEmptyStringTag() throws ArgsException{
        Args args = new Args(new String[]{"-l","-p","-d"});
        Parser parser = new Parser(schema,args);
        assertThat(parser.getValue("d")).isEqualTo("");
    }

}
