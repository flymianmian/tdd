package com.tdd.marsrover;

import java.rmi.MarshalException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    private List<String> commands;

    void receiveCommand(String command) throws MarsRoverException {
        List<String> commands = command.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList());
        String wrongCommand = commands.stream().filter(c -> !c.matches("^[FBLR]$")).findFirst().orElse(null);
        if (null != wrongCommand) {
            throw new MarsRoverException("Unknown command: " + wrongCommand);
        }
        this.commands = commands;
    }

    List<String> getCommands() {
        return this.commands;
    }

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

    private void turn(int offset) {
        int enumSize = Orientation.values().length;
        int index = (this.orientation.ordinal() + offset + enumSize) % enumSize;
        this.orientation = Orientation.values()[index];
    }

    void turnLeft() {
        int offset = -1;
        turn(offset);
    }

    void turnRight() {
        int offset = 1;
        turn(offset);
    }

    private int getXStep(Direction direction) {
        if (orientation == Orientation.EAST) {
            return direction == Direction.FORWARD ? 1 : -1;
        }
        if (orientation == Orientation.WEST) {
            return direction == Direction.FORWARD ? -1 : 1;
        }
        return 0;
    }

    private int getYStep(Direction direction) {
        if (orientation == Orientation.NORTH) {
            return direction == Direction.FORWARD ? 1 : -1;
        }
        if (orientation == Orientation.SOUTH) {
            return direction == Direction.FORWARD ? -1 : 1;
        }
        return 0;
    }

    private void move(Direction direction) throws MarsRoverException {
        int xStep = getXStep(direction);
        int yStep = getYStep(direction);
        Coordinate newCoordinate = new Coordinate(this.coordinate.getX() + xStep, this.coordinate.getY() + yStep);
        if (encounteredBarrier(newCoordinate)) {
            throw new MarsRoverException(String.format("Rover is move to a barrier %s", newCoordinate.toString()));
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
