package com.tdd.args;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ArgsTest {
    @Test
    void testArgs() {
        Args args = new Args(new String[]{"-l", "-p 1080", "-d /usr/logs"});
        List<Argument> arguments = args.getArguments();
        assertThat(arguments.size()).isEqualTo(3);
        assertThat(arguments.get(0).tag).isEqualTo("l");
        assertThat(arguments.get(0).value).isNull();
        assertThat(arguments.get(1).tag).isEqualTo("p");
        assertThat(arguments.get(1).value).isEqualTo("1080");
        assertThat(arguments.get(2).tag).isEqualTo("d");
        assertThat(arguments.get(2).value).isEqualTo("/usr/logs");
    }
}
