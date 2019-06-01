package com.tdd.currency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-01
 * Description:
 **/
class DollarTest {
    @Test
    void DollarMultiplyTest() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount()).isEqualTo(10);
        product = five.times(3);
        assertThat(product.amount()).isEqualTo(15);
    }

    @Test
    void DollarEqualityTest(){
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
    }
}
