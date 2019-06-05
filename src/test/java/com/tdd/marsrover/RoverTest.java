package com.tdd.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static com.tdd.marsrover.Orientation.*;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
class RoverTest {
    private Map map = new Map(10, 10);

    @BeforeEach
    void initMap() throws MarsRoverException {
        Barrier barrier1 = new Barrier(new Coordinate(3, 3));
        Barrier barrier2 = new Barrier(new Coordinate(5, 8));
        Barrier barrier3 = new Barrier(new Coordinate(7, 9));
        map.addBarrier(barrier1);
        map.addBarrier(barrier2);
        map.addBarrier(barrier3);
    }


    @Test
    void testCreateRover() throws MarsRoverException {
        Rover rover = new Rover(map, new Coordinate(5, 5), EAST);
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(5, 5));
        assertThat(rover.getOrientation()).isEqualTo(EAST);
    }

    @Test
    void should_throw_exception_when_rover_coordinate_is_out_of_map() {
        assertThatThrownBy(() -> new Rover(map, new Coordinate(15, 5), EAST))
                .isInstanceOf(MarsRoverException.class)
                .hasMessageContaining("Rover's coordinate (x:15, y:5) is out of map (width:10, height:10)");
    }

    @Test
    void should_throw_exception_when_rover_s_start_coordinate_is_on_a_barrier() {
        assertThatThrownBy(() -> new Rover(map, new Coordinate(5, 8), EAST))
                .isInstanceOf(MarsRoverException.class)
                .hasMessageContaining("Rover's start coordinate (x:5, y:8) is a barrier");
    }

    @Test
    void testTurn() throws MarsRoverException {
        Rover rover = new Rover(map, new Coordinate(5, 5), EAST);
        rover.turnLeft();
        assertThat(rover.getOrientation()).isEqualTo(NORTH);
        rover.turnLeft();
        assertThat(rover.getOrientation()).isEqualTo(WEST);
        rover.turnLeft();
        assertThat(rover.getOrientation()).isEqualTo(SOUTH);
        rover.turnLeft();
        assertThat(rover.getOrientation()).isEqualTo(EAST);
        rover.turnRight();
        assertThat(rover.getOrientation()).isEqualTo(SOUTH);
        rover.turnRight();
        assertThat(rover.getOrientation()).isEqualTo(WEST);
        rover.turnRight();
        assertThat(rover.getOrientation()).isEqualTo(NORTH);
        rover.turnRight();
        assertThat(rover.getOrientation()).isEqualTo(EAST);
    }

    @Test
    void testMove() throws MarsRoverException {
        Rover rover = new Rover(map, new Coordinate(5, 5), EAST);
        rover.moveForward();
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(6, 5));
        rover.moveBackward();
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(5, 5));
        rover.turnLeft();
        rover.moveForward();
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(5, 6));
        rover.moveBackward();
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(5, 5));
        rover.turnLeft();
        rover.moveForward();
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(4, 5));
        rover.moveBackward();
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(5, 5));
        rover.turnLeft();
        rover.moveForward();
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(5, 4));
        rover.moveBackward();
        assertThat(rover.getCoordinate()).isEqualTo(new Coordinate(5, 5));
    }

    @Test
    void should_stay_when_rover_move_to_a_barrier() throws MarsRoverException {
        Rover rover1 = new Rover(map, new Coordinate(4, 8), EAST);
        assertThatThrownBy(rover1::moveForward)
                .isInstanceOf(MarsRoverException.class)
                .hasMessageContaining("Rover is move to a barrier (x:5, y:8)");
        assertThat(rover1.getCoordinate()).isEqualTo(new Coordinate(4, 8));
        Rover rover2 = new Rover(map, new Coordinate(6, 8), EAST);
        assertThatThrownBy(rover2::moveBackward)
                .isInstanceOf(MarsRoverException.class)
                .hasMessageContaining("Rover is move to a barrier (x:5, y:8)");
        assertThat(rover2.getCoordinate()).isEqualTo(new Coordinate(6, 8));
    }

    @Test
    void should_receive_command() throws MarsRoverException {
        Rover rover = new Rover(map, new Coordinate(5, 5), EAST);
        rover.receiveCommand("FBLR");
        assertThat(rover.getCommands().size()).isEqualTo(4);
        assertThat(rover.getCommands().get(0)).isEqualTo("F");
        assertThat(rover.getCommands().get(1)).isEqualTo("B");
        assertThat(rover.getCommands().get(2)).isEqualTo("L");
        assertThat(rover.getCommands().get(3)).isEqualTo("R");
    }

    @Test
    void should_throw_exception_when_receive_wrong_command() throws MarsRoverException{
        Rover rover = new Rover(map, new Coordinate(5, 5), EAST);
        assertThatThrownBy(()->rover.receiveCommand("FBALR"))
                .isInstanceOf(MarsRoverException.class)
                .hasMessageContaining("Unknown command: A");
    }
}
