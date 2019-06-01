package com.tdd.currency;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-01
 * Description:
 **/
abstract class Money {
    int amount;
    String currency;

    static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    static Franc franc(int amount) {
        return new Franc(amount);
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount && this.getClass().equals(money.getClass());
    }

    abstract Money times(int multiplier);

    public String currency(){
        return this.currency;
    }
}
