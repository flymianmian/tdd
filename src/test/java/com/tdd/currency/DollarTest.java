package com.tdd.currency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-01
 * Description:
 **/
public class DollarTest {
    @Test
    void DollarMultiplyTest() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertThat(five.amount()).isEqualTo(10);
    }
}
