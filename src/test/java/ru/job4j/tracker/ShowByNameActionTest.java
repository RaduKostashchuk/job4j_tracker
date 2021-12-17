package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowByNameActionTest {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    public void whenShowByName() {
        Store tracker = new MemTracker();
        Item item = new Item("Show me");
        tracker.add(item);
        Output output = new StubOutput();
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        UserAction action = new ShowByNameAction(output);
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find item by name ===" + ln
                + "Item{"
                + "id=" + item.getId()
                + ", name='" + item.getName() + '\''
                + ", created=" + item.getLocalDateTime().format(FORMATTER)
                + '}' + ln));
    }

}