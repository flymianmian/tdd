package com.tdd.marsrover;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2019-06-04
 * Description:
 **/
public class Map {
    private int width;
    private int height;
    private List<Barrier> barriers = new ArrayList<>();

    public
    Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    void addBarrier(Barrier barrier) {
        this.barriers.add(barrier);
    }

    List<Barrier> getBarriers() {
        return this.barriers;
    }
}
