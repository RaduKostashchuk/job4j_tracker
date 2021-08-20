package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenInvalidExit() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"3", "1"});
        Output output = new StubOutput();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu:" + ln
            + "0. Show all items" + ln
            + "1. Exit program" + ln
            + "Wrong input, you can select from 0 to " + (actions.size() - 1) + "." + ln
            + "Menu:" + ln
            + "0. Show all items" + ln
            + "1. Exit program" + ln));
    }

    @Test
    public void whenAddAndFindByName() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        tracker.add(new Item("test"));
        String item = tracker.findAll().get(0).toString();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowByNameAction(out));
        actions.add(new ExitAction());
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
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
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
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
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
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowByNameAction(out));
        actions.add(new ExitAction());
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
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowByIdAction(out));
        actions.add(new ExitAction());
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
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        tracker.add(new Item("Original item"));
        int id = tracker.findAll().get(0).getId();
        Input input = new StubInput(new String[] {"0", Integer.toString(id), "Replaced item", "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        tracker.add(new Item("Item"));
        int id = tracker.findAll().get(0).getId();
        Input input = new StubInput(new String[] {"0", Integer.toString(id), "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findById(1), is(nullValue()));
    }
}