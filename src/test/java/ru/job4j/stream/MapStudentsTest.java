package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MapStudentsTest {

    @Test
    public void when4StudentsTo2Entries() {
        MapStudents ms = new MapStudents();
        List<Student> list = List.of(
                new Student(20, "Ivan"),
                new Student(80, "Danil"),
                new Student(20, "Ivan"),
                new Student(80, "Danil")
        );
        Map<String, Student> result = ms.listToMap(list);
        Set<String> expected = new HashSet<>(List.of("Ivan", "Danil"));
        assertThat(result.keySet(), is(expected));
    }
}