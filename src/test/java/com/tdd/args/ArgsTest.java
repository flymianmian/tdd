package com.tdd.args;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-05-30
 * Description:
 **/
class ArgsTest {
    private Args args = new Args(new String[]{"-l", "-p 1080", "-d /usr/logs"});

    @Test
    void test_build_args_from_definition() {
        List<Argument> arguments = args.getArguments();
        assertThat(arguments.size()).isEqualTo(3);
        assertThat(arguments.get(0).tag).isEqualTo("l");
        assertThat(arguments.get(0).value).isNull();
        assertThat(arguments.get(1).tag).isEqualTo("p");
        assertThat(arguments.get(1).value).isEqualTo("1080");
    }

    @Test
    void test_get_argument() {
        assertThat(args.getArgument("l").tag).isEqualTo("l");
        assertThat(args.getArgument("l").value).isNull();
        assertThat(args.getArgument("p").tag).isEqualTo("p");
        assertThat(args.getArgument("p").value).isEqualTo("1080");
    }
}
