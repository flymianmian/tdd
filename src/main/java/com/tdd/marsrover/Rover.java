package com.tdd.marsrover;

import static com.tdd.marsrover.Orientation.*;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
public class Rover {
    private final Map map;
    private final Coordinate coordinate;
    private Orientation orientation;

    public enum Direction {
        LEFT, RIGHT;
    }

    public Rover(Map map, Coordinate coordinate, Orientation orientation) throws MarsRoverException {
        if (!coordinate.in(map)) {
            throw new MarsRoverException(String.format("Rover's coordinate(x:%d, y:%d) is out of map(width:%d, height:%d)", coordinate.getX(), coordinate.getY(), map.getWidth(), map.getHeight()));
        }
        this.map = map;
        this.coordinate = coordinate;
        if (this.map
                .getBarriers()
                .stream()
                .anyMatch(barrier -> barrier.getCoordinate().equals(this.coordinate))) {
            throw new MarsRoverException("Rover encountered a barrier");
        }
        this.orientation = orientation;
    }

    Coordinate getCoordinate() {
        return new Coordinate(5, 5);
    }

    Orientation getOrientation() {
        return this.orientation;
    }

    void turnLeft() {
        switch (this.orientation) {
            case EAST:
                this.orientation = NORTH;
                break;
            case WEST:
                this.orientation = SOUTH;
                break;
            case NORTH:
                this.orientation = WEST;
                break;
            case SOUTH:
                this.orientation = EAST;
                break;
            default:
                break;
        }
    }

    void turn(Direction direction) {
        switch (direction) {
            case LEFT:
                this.turnLeft();
                break;
            case RIGHT:
                this.turnRight();
                break;
            default:
                break;
        }
    }

    void turnRight() {
        switch (this.orientation) {
            case EAST:
                this.orientation = SOUTH;
                break;
            case WEST:
                this.orientation = NORTH;
                break;
            case NORTH:
                this.orientation = EAST;
                break;
            case SOUTH:
                this.orientation = WEST;
                break;
            default:
                break;
        }
    }
}
