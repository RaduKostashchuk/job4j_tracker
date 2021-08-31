package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MapStudentsTest {

    @Test
    public void when4StudentsTo2Entries() {
        MapStudents ms = new MapStudents();
        List<Student> list = List.of(
                new Student("Ivan", 20),
                new Student("Danil", 80),
                new Student("Ivan", 20),
                new Student("Danil", 80)
        );
        Map<String, Student> result = ms.listToMap(list);
        Set<String> expected = new HashSet<>(List.of("Ivan", "Danil"));
        assertThat(result.keySet(), is(expected));
    }

    @Test
    public void whenListEmpty() {
        MapStudents ms = new MapStudents();
        List<Student> list = new ArrayList<>();
        Map<String, Student> result = ms.listToMap(list);
        assertTrue(result.values().isEmpty());
    }
}