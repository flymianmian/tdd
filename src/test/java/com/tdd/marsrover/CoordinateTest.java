package com.tdd.marsrover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
class CoordinateTest {
    @Test
    void testCoordinate() {
        Coordinate coordinate = new Coordinate(10, 10);
        assertThat(coordinate.getX()).isEqualTo(10);
        assertThat(coordinate.getY()).isEqualTo(10);
        coordinate = new Coordinate(5, 5);
        assertThat(coordinate.getX()).isEqualTo(5);
        assertThat(coordinate.getY()).isEqualTo(5);
    }

    @Test
    void testCoordinateEqual() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 10);
        assertThat(c1).isEqualTo(c2);
        Coordinate c3 = new Coordinate(5, 5);
        assertThat(c1).isNotEqualTo(c3);
    }

    @Test
    void testCoordinateIn() {
        Coordinate c1 = new Coordinate(5, 5);
        assertThat(c1.in(new Map(10, 10))).isTrue();
        Coordinate c2 = new Coordinate(15, 5);
        assertThat(c2.in(new Map(10, 10))).isFalse();
    }

    @Test
    void testDirection() {
        Orientation east = Orientation.EAST;
        assertThat(east).isEqualTo(Orientation.EAST);
        assertThat(east).isNotEqualTo(Orientation.WEST);
    }

    @Test
    void testToString(){
        Coordinate coordinate = new Coordinate(5,5);
        assertThat(coordinate.toString()).isEqualTo("(x:5, y:5)");
    }
}
