package ru.job4j.tracker.input;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ValidateInput implements Input {
    private final Input input;
    private final Output output;

    public ValidateInput(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Please enter valid number");
            }

        } while (invalid);
        return value;
    }
}
