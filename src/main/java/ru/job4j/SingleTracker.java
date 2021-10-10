package ru.job4j;

import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Item;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private MemTracker tracker = new MemTracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

}
