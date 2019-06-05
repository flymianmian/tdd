package com.tdd.marsrover;

import java.rmi.MarshalException;

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

    private enum Direction {
        FORWARD, BACKWARD
    }

    public Rover(Map map, Coordinate coordinate, Orientation orientation) throws MarsRoverException {
        if (!coordinate.in(map)) {
            throw new MarsRoverException(String.format("Rover's coordinate %s is out of map (width:%d, height:%d)", coordinate.toString(), map.getWidth(), map.getHeight()));
        }
        this.map = map;
        this.coordinate = coordinate;
        this.orientation = orientation;
        if (encounteredBarrier(this.coordinate)) {
            throw new MarsRoverException(String.format("Rover's start coordinate %s is a barrier", coordinate.toString()));
        }
    }

    private boolean encounteredBarrier(Coordinate coordinate) {
        return this.map
                .getBarriers()
                .stream()
                .anyMatch(barrier -> barrier.getCoordinate().equals(coordinate));
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

    int getXStep(Direction direction) {
        if (orientation == Orientation.EAST) {
            return direction == Direction.FORWARD ? 1 : -1;
        }
        if (orientation == Orientation.WEST) {
            return direction == Direction.FORWARD ? -1 : 1;
        }
        return 0;
    }

    int getYStep(Direction direction) {
        if (orientation == Orientation.NORTH) {
            return direction == Direction.FORWARD ? 1 : -1;
        }
        if (orientation == Orientation.SOUTH) {
            return direction == Direction.FORWARD ? -1 : 1;
        }
        return 0;
    }

    void move(Direction direction) throws MarsRoverException {
        int xStep = getXStep(direction);
        int yStep = getYStep(direction);
        Coordinate newCoordinate = new Coordinate(this.coordinate.getX() + xStep, this.coordinate.getY() + yStep);
        if (encounteredBarrier(newCoordinate)) {
            throw new MarsRoverException(String.format("Rover is move to a is a barrier %s", newCoordinate.toString()));
        }
        this.coordinate = newCoordinate;
    }

    void moveForward() throws MarsRoverException {
        move(Direction.FORWARD);
    }

    void moveBackward() throws MarsRoverException {
        move(Direction.BACKWARD);
    }
}
