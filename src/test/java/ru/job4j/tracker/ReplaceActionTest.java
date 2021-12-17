package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReplaceActionTest {

    @Test
    public void whenExecute() {
        Store tracker = new MemTracker();
        tracker.add(new Item("Original"));
        Output out = new StubOutput();
        Input input = mock(Input.class);
        UserAction action = new ReplaceAction(out);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn("Replaced");
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Заявка изменена успешно." + ln));
    }

}