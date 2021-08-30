package ru.job4j.stream;

public class BuilderUsage {
    public static void main(String[] args) {
        DBQuery dbQuery = new DBQuery.Builder()
                .buildServer("localhost")
                .buildUser("root")
                .buildPassword("123qwe")
                .buildDatabase("main")
                .buildTable("clients")
                .buildType("select")
                .buildContent("where id = 30")
                .build();

        System.out.println(dbQuery);
    }
}
