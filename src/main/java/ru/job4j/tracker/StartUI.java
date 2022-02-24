package ru.job4j.tracker;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> list) {
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
        for (int index = 0; index < list.size(); index++) {
            out.println(index + ". " + list.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), out);
        Store tracker = new SqlTracker();
        List<UserAction> list = List.of(
                new CreateAction(out),
                new ShowAllAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new ShowByIdAction(out),
                new ShowByNameAction(out),
                new ExitAction());
        new StartUI(out).init(input, tracker, list);
    }
}
