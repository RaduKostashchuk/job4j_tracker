package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item[] findAll() {
        return items.toArray(new Item[items.size()]);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int result = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                result = items.indexOf(item);
                break;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.size()];
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result[count++] = item;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }
}