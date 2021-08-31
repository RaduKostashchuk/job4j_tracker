package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student("Surname1", 10),
                new Student("Surname4", 40),
                new Student("Surname5", 50),
                new Student("Surname7", 70),
                new Student("Surname9", 90)
        );
        School sc = new School();
        Predicate<Student> pr = n -> n.getScore() >= 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Surname7", 70));
        expected.add(new Student("Surname9", 90));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student("Surname2", 20),
                new Student("Surname3", 30),
                new Student("Surname5", 50),
                new Student("Surname6", 60),
                new Student("Surname8", 80)
        );
        School sc = new School();
        Predicate<Student> pr1 = n -> n.getScore() >= 50;
        Predicate<Student> pr2 = n -> n.getScore() < 70;
        Predicate<Student> pr = pr1.and(pr2);
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Surname5", 50));
        expected.add(new Student("Surname6", 60));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassV() {
        List<Student> list = List.of(
                new Student("Surname1", 10),
                new Student("Surname3", 30),
                new Student("Surname4", 40),
                new Student("Surname6", 60),
                new Student("Surname9", 90)
        );
        School sc = new School();
        Predicate<Student> pr = n -> n.getScore() < 50;
        List<Student> result = sc.collect(list, pr);
        List<Student> expected = List.of(
                new Student("Surname1", 10),
                new Student("Surname3", 30),
                new Student("Surname4", 40)
        );
        assertThat(result, is(expected));
    }

}