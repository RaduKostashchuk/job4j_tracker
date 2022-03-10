package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.model.ItemSortAsc;
import ru.job4j.tracker.model.ItemSortDesc;

import java.util.*;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortAsc() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item(1, "test 1");
        Item item2 = new Item(2, "test 2");
        Item item5 = new Item(5, "test 5");
        Item item7 = new Item(7, "test 7");
        list.add(item7);
        list.add(item1);
        list.add(item5);
        list.add(item2);
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item5);
        expected.add(item7);
        Comparator<Item> comp = new ItemSortAsc();
        list.sort(comp);
        assertEquals(expected, list);
    }

    @Test
    public void whenSortDesc() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item(1, "test 1");
        Item item2 = new Item(2, "test 2");
        Item item5 = new Item(5, "test 5");
        Item item7 = new Item(7, "test 7");
        list.add(item7);
        list.add(item1);
        list.add(item5);
        list.add(item2);
        List<Item> expected = new ArrayList<>();
        expected.add(item7);
        expected.add(item5);
        expected.add(item2);
        expected.add(item1);
        Comparator<Item> comp = new ItemSortDesc();
        list.sort(comp);
        assertEquals(expected, list);
    }

}