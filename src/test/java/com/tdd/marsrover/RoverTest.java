package com.tdd.marsrover;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
class RoverTest {
    private Map map = new Map(10, 10);

    @BeforeEach
    void initMap() {
        Barrier barrier1 = new Barrier(new Coordinate(3, 3));
        Barrier barrier2 = new Barrier(new Coordinate(5, 8));
        Barrier barrier3 = new Barrier(new Coordinate(7, 9));
        map.addBarrier(barrier1);
        map.addBarrier(barrier2);
        map.addBarrier(barrier3);
    }


    @Test
    void testCreateRover() {
        Rover rover = new Rover(map, new Coordinate(5, 5), Direction.EAST);
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(5, 5));
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }
}
