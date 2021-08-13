package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String[] answers = {"0", "Item name", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        String[] answers = {"0", "1", "Replaced item", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        tracker.add(new Item("Original item"));
        UserAction[] actions = {new ReplaceAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Replaced item"));
    }

    @Test
    public void whenDelete() {
        String[] answers = {"0", "1", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item"));
        UserAction[] actions = {new DeleteAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(1), is(nullValue()));
    }
}