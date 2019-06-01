package com.tdd.currency;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-01
 * Description:
 **/
public class Dollar extends Money {

    Dollar(int amount) {
        this.amount = amount;
    }


    Money times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public int amount() {
        return this.amount;
    }
}
