package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenDelete() {
        Store tracker = new MemTracker();
        Output output = new StubOutput();
        Input input = mock(Input.class);
        Item item = new Item("To delete");
        tracker.add(item);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        UserAction delete = new DeleteAction(output);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(),
                is("=== Delete item ==" + ln + "Заявка удалена успешно." + ln));
    }

}