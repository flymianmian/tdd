package com.tdd.marsrover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
class CoordinateTest {
    @Test
    void testCoordinate(){
        Coordinate coordinate = new Coordinate(10,10);
        assertThat(coordinate.getX()).isEqualTo(10);
        assertThat(coordinate.getY()).isEqualTo(10);
        coordinate = new Coordinate(5,5);
        assertThat(coordinate.getX()).isEqualTo(5);
        assertThat(coordinate.getY()).isEqualTo(5);
    }
}
