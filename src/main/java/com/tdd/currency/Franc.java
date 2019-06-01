package com.tdd.currency;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-01
 * Description:
 **/
public class Franc extends Money {
    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public int amount() {
        return this.amount;
    }
}
