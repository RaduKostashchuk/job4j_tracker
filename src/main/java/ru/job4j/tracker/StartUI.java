package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] array) {
        boolean run = true;
        while (run) {
            showMenu(array);
            int select = input.askInt("Select:");
            if (select < 0 || select >= array.length) {
                out.println("Wrong input, you can select from 0 to "
                        + (array.length - 1) + ".");
                continue;
            }
            run = array[select].execute(input, tracker);
         }
    }

    private void showMenu(UserAction[] array) {
        out.println("Menu:");
        for (int index = 0; index < array.length; index++) {
            out.println(index + ". " + array[index].name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), out);
        Tracker tracker = new Tracker();
        UserAction[] array = {new CreateAction(out), new ShowAllAction(out), new ReplaceAction(out),
                new DeleteAction(out), new ShowByIdAction(out), new ShowByNameAction(out),
                new ExitAction()};
        new StartUI(out).init(input, tracker, array);
    }
}
