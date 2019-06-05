package com.tdd.args;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-30
 * Description:
 **/
class ParserTest {
    private Schema schema = new Schema(new String[]{"l:boolean", "p:integer", "d:string"});

    /**
     * boolean argument
     */
    @Test
    void should_return_true_when_argument_tag_is_given() throws ArgsException {
        Args args = new Args(new String[]{"-l"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }

    @Test
    void should_return_false_when_argument_tag_is_not_given() throws ArgsException {
        Args args = new Args(new String[]{});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    void should_return_true_when_argument_value_is_true() throws ArgsException {
        Args args = new Args(new String[]{"-l true"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }

    @Test
    void should_return_false_when_argument_value_is_false() throws ArgsException {
        Args args = new Args(new String[]{"-l false"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    void should_throw_exception_when_boolean_argument_value_is_invalid() {
        Args args = new Args(new String[]{"-l 123"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("l"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Invalid boolean value found: 123");
    }

    /**
     * integer argument
     */
    @Test
    void should_return_1080_when_1080_is_given() throws ArgsException {
        Args args = new Args(new String[]{"-p 1080"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("p")).isEqualTo(1080);
    }

    @Test
    void should_return_0_when_value_is_not_given() throws ArgsException {
        Args args = new Args(new String[]{""});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("p")).isEqualTo(0);
    }

    @Test
    void should_throw_exception_when_integer_argument_value_is_invalid() {
        Args args = new Args(new String[]{"-p abc"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("p"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Invalid integer value found: abc");
    }

    @Test
    void should_throw_exception_when_integer_argument_value_is_empty() {
        Args args = new Args(new String[]{"-p"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("p"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("No value found for integer argument: p");
    }

    /**
     * string argument
     */
    @Test
    void should_return_abc_when_abc_is_given() throws ArgsException {
        Args args = new Args(new String[]{"-d abc"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("d")).isEqualTo("abc");
    }

    @Test
    void should_return_empty_string_when_value_is_not_given() throws ArgsException {
        Args args = new Args(new String[]{""});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("d")).isEqualTo("");
    }

    @Test
    void should_throw_exception_when_string_argument_value_is_empty() {
        Args args = new Args(new String[]{"-d"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("d"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("No value found for string argument: d");
    }

    /**
     * array argument
     */
    @Test
    void should_return_array_when_array_tag_is_given() throws ArgsException {
        schema.addFlag(new Flag("a:array"));
        Args args = new Args(new String[]{"-a this,is,an,array"});
        Parser parser = new Parser(schema, args);
        assertThat(parser.getValue("a")).isEqualTo(new String[]{"this", "is", "an", "array"});
    }

    @Test
    void should_throw_exception_when_array_argument_value_is_empty(){
        schema.addFlag(new Flag("a:array"));
        Args args = new Args(new String[]{"-a"});
        Parser parser = new Parser(schema,args);
        assertThatThrownBy(() -> parser.getValue("a"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("No value found for array argument: a");
    }

    /**
     * exception
     */
    @Test
    void should_throw_exception_when_unknown_tag_is_given() {
        Args args = new Args(new String[]{"g"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("g"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Invalid argument tag found: g");
    }

    @Test
    void should_throw_exception_when_unknown_type_is_given() {
        Schema schema = new Schema(new String[]{"l:list"});
        Args args = new Args(new String[]{"l this,is,a,list"});
        Parser parser = new Parser(schema, args);
        assertThatThrownBy(() -> parser.getValue("l"))
                .isInstanceOf(ArgsException.class)
                .hasMessageContaining("Invalid argument type found: list");
    }
}
