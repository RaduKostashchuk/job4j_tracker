package ru.job4j.oop;

public class Programmer extends Engineer {
    private String lang;

    public String getLang() {
        return this.lang;
    }

    public Code dev(Task task) {
        Code progamm = new Code();
        return progamm;
    }

    public void test(Code code) {
    }
}
