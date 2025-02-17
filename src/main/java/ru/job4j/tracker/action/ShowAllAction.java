package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show all items ===");
        List<Item> result = new ArrayList<>();
        tracker.findAll(result::add);
        if (result.size() == 0) {
            out.println("Хранилище еще не содержит заявок");
        } else {
            for (Item item : result) {
                out.println(item);
            }
        }
        return true;
    }
}
