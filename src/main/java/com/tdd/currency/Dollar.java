package com.tdd.currency;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-01
 * Description:
 **/
public class Dollar {
    int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    public int amount() {
        return this.amount;
    }
}
