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
        Dollar product = five.times(2);
        assertThat(product.amount()).isEqualTo(10);
        product = five.times(3);
        assertThat(product.amount()).isEqualTo(15);
    }
}
