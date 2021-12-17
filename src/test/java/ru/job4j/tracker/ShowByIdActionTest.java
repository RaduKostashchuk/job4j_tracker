package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowByIdActionTest {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    public void whenShowById() {
        Store tracker = new MemTracker();
        Item item = new Item("Find me");
        Output output = new StubOutput();
        tracker.add(item);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        UserAction action = new ShowByIdAction(output);
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find item by id ===" + ln
                + "Item{"
                + "id=" + item.getId()
                + ", name='" + item.getName() + '\''
                + ", created=" + item.getLocalDateTime().format(FORMATTER)
                + '}' + ln));
    }

}