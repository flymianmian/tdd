package com.tdd.marsrover;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
class MapTest {

    @Test
    void testMap() {
        Map map = new Map(10, 10);
        assertThat(map.getWidth()).isEqualTo(10);
        assertThat(map.getHeight()).isEqualTo(10);
        map = new Map(5, 8);
        assertThat(map.getWidth()).isEqualTo(5);
        assertThat(map.getHeight()).isEqualTo(8);
    }

    @Test
    void testAddBarrier() {
        Map map = new Map(10, 10);
        Barrier barrier = new Barrier(new Coordinate(5, 5));
        map.addBarrier(barrier);
        List<Barrier> barriers = map.getBarriers();
        assertThat(barriers.size()).isEqualTo(1);
        assertThat(barriers.get(0).getCoordinate()).isEqualTo(new Coordinate(5, 5));
    }
}
