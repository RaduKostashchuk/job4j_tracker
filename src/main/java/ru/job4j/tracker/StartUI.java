package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> list) {
        boolean run = true;
        while (run) {
            showMenu(list);
            int select = input.askInt("Select:");
            if (select < 0 || select >= list.size()) {
                out.println("Wrong input, you can select from 0 to "
                        + (list.size() - 1) + ".");
                continue;
            }
            run = list.get(select).execute(input, tracker);
         }
    }

    private void showMenu(List<UserAction> list) {
        out.println("Menu:");
        int index = 0;
        for (UserAction action : list) {
            out.println(index++ + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), out);
        Tracker tracker = new Tracker();
        List<UserAction> list = new ArrayList<>();
        list.add(new CreateAction(out));
        list.add(new ShowAllAction(out));
        list.add(new ReplaceAction(out));
        list.add(new DeleteAction(out));
        list.add(new ShowByIdAction(out));
        list.add(new ShowByNameAction(out));
        list.add(new ExitAction());
        new StartUI(out).init(input, tracker, list);
    }
}
