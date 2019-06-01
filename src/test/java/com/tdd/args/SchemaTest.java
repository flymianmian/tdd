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
class SchemaTest {
    private Schema schema = new Schema(new String[]{"l:boolean", "p:integer", "d:string"});

    @Test
    void should_build_schema_when_given_definition() {
        List<Flag> flags = schema.getFlags();
        assertThat(flags.size()).isEqualTo(3);
        assertThat(flags.get(0).type).isEqualTo("boolean");
        assertThat(flags.get(0).tag).isEqualTo("l");
    }

    @Test
    void should_return_true_if_any_flag_with_given_tag_in_the_schema() {
        assertThat(schema.hasFlag("l")).isTrue();
    }

    @Test
    void should_return_false_if_none_flag_with_given_tag_in_the_schema() {
        assertThat(schema.hasFlag("g")).isFalse();
    }

    @Test
    void should_return_flag_when_given_tag_name() {
        Flag flag = schema.getFlag("l");
        assertThat(flag.type.equals("boolean"));
        assertThat(flag.tag.equals("l"));
    }

    @Test
    void should_return_null_when_given_tag_not_in_schema() {
        Flag flag = schema.getFlag("g");
        assertThat(flag).isNull();
    }

}
