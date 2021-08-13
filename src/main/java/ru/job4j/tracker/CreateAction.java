package ru.job4j.tracker;

public class CreateAction implements UserAction {

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Create a new item ===");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("You created:" + item);
        return true;
    }
}
