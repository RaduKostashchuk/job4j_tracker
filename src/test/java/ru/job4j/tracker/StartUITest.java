package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddAndFindByName() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        tracker.add(new Item("test"));
        String item = tracker.findAll()[0].toString();
        UserAction[] actions = {new ShowByNameAction(out), new ExitAction()};
        Input input = new StubInput(new String[] {"0", "test", "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "=== Find item by name ===" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        UserAction[] actions = {new ExitAction()};
        Output out = new StubOutput();
        Input input = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new ShowAllAction(out), new ExitAction()};
        Input input = new StubInput(new String[] {"0", "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Show all items ===" + System.lineSeparator()
                        + "Хранилище еще не содержит заявок" + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new ShowByNameAction(out), new ExitAction()};
        Input input = new StubInput(new String[] {"0", "test", "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "=== Find item by name ===" + System.lineSeparator()
                + "Заявки с именем: test не найдены." + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new ShowByIdAction(out), new ExitAction()};
        Input input = new StubInput(new String[] {"0", "1", "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "=== Find item by id ===" + System.lineSeparator()
                + "Заявка с введенным id: 1 не найдена." + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input input = new StubInput(new String[] {"0", "Item name", "1"});
        UserAction[] actions = {new CreateAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        tracker.add(new Item("Original item"));
        int id = tracker.findAll()[0].getId();
        Input input = new StubInput(new String[] {"0", Integer.toString(id), "Replaced item", "1"});
        UserAction[] actions = {new ReplaceAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Replaced item"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        tracker.add(new Item("Item"));
        int id = tracker.findAll()[0].getId();
        Input input = new StubInput(new String[] {"0", Integer.toString(id), "1"});
        UserAction[] actions = {new DeleteAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findById(1), is(nullValue()));
    }
}