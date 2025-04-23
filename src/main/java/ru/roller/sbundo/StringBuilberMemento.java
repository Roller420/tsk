package ru.roller.sbundo;

public class StringBuilberMemento {
    private final String state;

    public StringBuilberMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
