package com.tdd.marsrover;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
public class Barrier {
    private final Coordinate coordinate;

    public Barrier(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    Coordinate getCoordinate() {
        return this.coordinate;
    }
}
