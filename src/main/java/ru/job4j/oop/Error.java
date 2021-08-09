package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    private Error() {
    }

    private Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    private void info() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error er1 = new Error();
        er1.info();
        Error er2 = new Error(true, 23, "Access denied");
        er2.info();
        Error er3 = new Error(false, 111, "Operation not permitted");
        er3.info();
    }
}
