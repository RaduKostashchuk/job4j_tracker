package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String lang;

    public Programmer(String name, String surname, String birthday,
                      String education, String indutry, String lang) {
        super(name, surname, birthday, education, indutry);
        this.lang = lang;
    }

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
