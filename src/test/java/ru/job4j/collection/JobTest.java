package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenAscNames() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Replace HDD", 1));
        list.add(new Job("Fix bug", 2));
        list.add(new Job("Impl task", 3));
        Comparator<Job> comp = new SortJobNameAsc();
        list.sort(comp);
        List<Job> expected = List.of(
                new Job("Fix bug", 2),
                new Job("Impl task", 3),
                new Job("Replace HDD", 1));
        assertEquals(expected, list);
    }

    @Test
    public void whenDescNames() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Replace HDD", 1));
        list.add(new Job("Fix bug", 2));
        list.add(new Job("Impl task", 3));
        Comparator<Job> comp = new SortJobNameDesc();
        list.sort(comp);
        List<Job> expected = List.of(
            new Job("Replace HDD", 1),
            new Job("Impl task", 3),
            new Job("Fix bug", 2));
        assertEquals(expected, list);
    }

    @Test
    public void whenAscPrio() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 3));
        list.add(new Job("Replace HDD", 1));
        list.add(new Job("Fix bug", 2));
        Comparator<Job> comp = new SortJobPrioAsc();
        list.sort(comp);
        List<Job> expected = List.of(
            new Job("Replace HDD", 1),
            new Job("Fix bug", 2),
            new Job("Impl task", 3));
        assertEquals(expected, list);
    }

    @Test
    public void whenDescPrio() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 3));
        list.add(new Job("Replace HDD", 1));
        list.add(new Job("Fix bug", 2));
        Comparator<Job> comp = new SortJobPrioDesc();
        list.sort(comp);
        List<Job> expected = List.of(
            new Job("Impl task", 3),
            new Job("Fix bug", 2),
            new Job("Replace HDD", 1));
        assertEquals(expected, list);
    }

    @Test
    public void whenAscNameAscPrio() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 3));
        list.add(new Job("Replace HDD", 1));
        list.add(new Job("Fix bug", 3));
        list.add(new Job("Fix bug", 2));
        Comparator<Job> comp = new SortJobNameAsc().thenComparing(new SortJobPrioAsc());
        list.sort(comp);
        List<Job> expected = List.of(
            new Job("Fix bug", 2),
            new Job("Fix bug", 3),
            new Job("Impl task", 3),
            new Job("Replace HDD", 1));
        assertEquals(expected, list);
    }

    @Test
    public void whenDescNameDescPrio() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 3));
        list.add(new Job("Replace HDD", 1));
        list.add(new Job("Fix bug", 3));
        list.add(new Job("Fix bug", 2));
        Comparator<Job> comp = new SortJobNameDesc().thenComparing(new SortJobPrioDesc());
        list.sort(comp);
        List<Job> expected = List.of(
            new Job("Replace HDD", 1),
            new Job("Impl task", 3),
            new Job("Fix bug", 3),
            new Job("Fix bug", 2));
        assertEquals(expected, list);
    }

    @Test
    public void whenDescNameAscPrio() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 3));
        list.add(new Job("Replace HDD", 1));
        list.add(new Job("Fix bug", 3));
        list.add(new Job("Fix bug", 2));
        Comparator<Job> comp = new SortJobNameDesc().thenComparing(new SortJobPrioAsc());
        list.sort(comp);
        List<Job> expected = List.of(
            new Job("Replace HDD", 1),
            new Job("Impl task", 3),
            new Job("Fix bug", 2),
            new Job("Fix bug", 3));
        assertEquals(expected, list);
    }
}