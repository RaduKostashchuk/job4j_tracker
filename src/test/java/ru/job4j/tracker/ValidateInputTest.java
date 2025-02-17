package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void wnehInvalidValid() {
        Input input = new StubInput(new String[] {"one", "1"});
        Output output = new StubOutput();
        ValidateInput valInput = new ValidateInput(input, output);
        int selected = valInput.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidValid() {
        String[] answers =  {"1", "1", "2"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        ValidateInput valInput = new ValidateInput(input, output);
        String[] array = new String[3];
        array[0] = Integer.toString(valInput.askInt("Enter menu:"));
        array[1] = Integer.toString(valInput.askInt("Enter menu:"));
        array[2] = Integer.toString(valInput.askInt("Enter menu:"));
        assertArrayEquals(array, answers);
    }

    @Test
    public void whenInvalidNegative() {
        String[] answers = new String[] {"-3"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        ValidateInput vlaInput = new ValidateInput(input, output);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(Integer.parseInt(answers[0])));
    }
}