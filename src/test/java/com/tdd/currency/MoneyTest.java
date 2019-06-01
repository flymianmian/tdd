package com.tdd.currency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-01
 * Description:
 **/
public class MoneyTest {
    @Test
    void testEquality(){
        assertThat(new Dollar(5)).isNotEqualTo(new Franc(5));
    }
}
