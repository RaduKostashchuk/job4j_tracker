package ru.job4j.tracker.model;

import java.util.Comparator;

public class ItemSortAsc implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
