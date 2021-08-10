package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void when23Then3() {
        Max obj = new Max();
        int first = 2;
        int second = 3;
        int expected = 3;
        int result = obj.max(first, second);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void when745Then7() {
        Max obj = new Max();
        int first = 7;
        int second = 4;
        int third = 5;
        int expected = 7;
        int result = obj.max(first, second, third);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void when31098Then10() {
        Max obj = new Max();
        int first = 3;
        int second = 10;
        int third = 9;
        int fourth = 8;
        int expected = 10;
        int result = obj.max(first, second, third, fourth);
        Assert.assertEquals(expected, result);
    }
}