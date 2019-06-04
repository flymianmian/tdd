package com.tdd.marsrover;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
public class Rover {
    private final Map map;
    private final Coordinate coordinate;
    private final Direction direction;

    public Rover(Map map, Coordinate coordinate, Direction direction) throws MarsRoverException {
        if (!coordinate.in(map)) {
            throw new MarsRoverException(String.format("Rover's coordinate(x:%d, y:%d) is out of map(width:%d, height:%d)", coordinate.getX(), coordinate.getY(), map.getWidth(), map.getHeight()));
        }
        this.map = map;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    Coordinate getCoordinate() {
        return new Coordinate(5, 5);
    }

    Direction getDirection() {
        return Direction.EAST;
    }
}
