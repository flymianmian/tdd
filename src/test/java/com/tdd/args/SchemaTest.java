package com.tdd.args;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SchemaTest {
    @Test
    void testSchema() {
        Schema schema = new Schema(new String[]{"l:boolean", "p:integer", "d:string"});
        List<Flag> flags = schema.getFlags();
        assertThat(flags.size()).isEqualTo(3);
        assertThat(flags.get(0).tag).isEqualTo("l");
        assertThat(flags.get(0).type).isEqualTo("boolean");
        assertThat(flags.get(1).tag).isEqualTo("p");
        assertThat(flags.get(1).type).isEqualTo("integer");
        assertThat(flags.get(2).tag).isEqualTo("d");
        assertThat(flags.get(2).type).isEqualTo("string");
    }

    @Test
    void testSchemaContainTag() {
        Schema schema = new Schema(new String[]{"l:boolean", "p:integer", "d:string"});
        assertThat(schema.containFlag("l")).isTrue();
        assertThat(schema.containFlag("p")).isTrue();
        assertThat(schema.containFlag("d")).isTrue();
        assertThat(schema.containFlag("g")).isFalse();
    }

    @Test
    void testGetFlag() {
        Schema schema = new Schema(new String[]{"l:boolean", "p:integer", "d:string"});
        Flag flag = schema.getFlag("l");
        assertThat(flag.tag).isEqualTo("l");
        assertThat(flag.type).isEqualTo("boolean");
        flag = schema.getFlag("p");
        assertThat(flag.tag).isEqualTo("p");
        assertThat(flag.type).isEqualTo("integer");
        flag = schema.getFlag("d");
        assertThat(flag.tag).isEqualTo("d");
        assertThat(flag.type).isEqualTo("string");
        flag = schema.getFlag("g");
        assertThat(flag).isNull();
    }
}