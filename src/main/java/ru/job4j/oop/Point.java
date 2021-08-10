package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point another) {
        return sqrt(pow(this.x - another.x, 2) + pow(this.y - another.y, 2));
    }

    public double distance3d(Point another) {
        return sqrt(pow(this.x - another.x, 2)
        + pow(this.y - another.y, 2)
        + pow(this.z - another.z, 2));
    }

    public void info() {
        System.out.println("Point [" + this.x + ", " + this.y + "]");
    }

    public void info3d() {
        System.out.println("Point [" + this.x + ", " + this.y + ", " + this.z + "]");
    }
 }
