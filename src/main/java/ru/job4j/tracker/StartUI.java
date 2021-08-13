package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] array) {
        boolean run = true;
        while (run) {
            showMenu(array);
            int select = input.askInt("Select:");
            run = array[select].execute(input, tracker);
         }
    }

    private void showMenu(UserAction[] array) {
        System.out.println("Menu:");
        for (int index = 0; index < array.length; index++) {
            System.out.println(index + ". " + array[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] array = {new CreateAction(), new ShowAllAction(), new ReplaceAction(),
                new DeleteAction(), new ShowByIdAction(), new ShowByNameAction(), new ExitAction()};
        new StartUI().init(input, tracker, array);
    }
}
