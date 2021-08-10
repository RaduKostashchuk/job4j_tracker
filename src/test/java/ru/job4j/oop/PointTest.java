package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {

    @Test
    public void when0002Then2() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 2);
        double expected = 2;
        double result = first.distance(second);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void when000101010Then1732() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(10, 10, 10);
        double expected = 17.320;
        double result = first.distance3d(second);
        Assert.assertEquals(expected, result, 0.001);
    }
}