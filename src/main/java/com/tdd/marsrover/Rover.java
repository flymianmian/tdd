package com.tdd.marsrover;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
public class Rover {
    private final Map map;
    private Coordinate coordinate;
    private Orientation orientation;

    public Rover(Map map, Coordinate coordinate, Orientation orientation) throws MarsRoverException {
        if (!coordinate.in(map)) {
            throw new MarsRoverException(String.format("Rover's coordinate(x:%d, y:%d) is out of map(width:%d, height:%d)", coordinate.getX(), coordinate.getY(), map.getWidth(), map.getHeight()));
        }
        this.map = map;
        this.coordinate = coordinate;
        this.orientation = orientation;
        if (encounteredBarrier()) {
            throw new MarsRoverException(String.format("Rover's coordinate(x:%d, y:%d) encountered a barrier", coordinate.getX(), coordinate.getY()));
        }
    }

    private boolean encounteredBarrier() {
        return this.map
                .getBarriers()
                .stream()
                .anyMatch(barrier -> barrier.getCoordinate().equals(this.coordinate));
    }

    Coordinate getCoordinate() {
        return this.coordinate;
    }

    Orientation getOrientation() {
        return this.orientation;
    }

    void turnLeft() {
        int index = (this.orientation.ordinal() + 3) % 4;
        this.orientation = Orientation.values()[index];
    }

    void turnRight() {
        int index = (this.orientation.ordinal() + 5) % 4;
        this.orientation = Orientation.values()[index];
    }

    void moveForward() {
        this.coordinate = new Coordinate(this.coordinate.getX() + 1, this.coordinate.getY());
    }

    void moveBackward() {
        this.coordinate = new Coordinate(this.coordinate.getX() - 1, this.coordinate.getY());
    }
}
