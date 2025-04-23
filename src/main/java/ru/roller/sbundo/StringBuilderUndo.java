package ru.roller.sbundo;

import java.util.Stack;

public class StringBuilderUndo {
    private final StringBuilder stringBuilder;
    private final Stack<StringBuilberMemento> stack = new Stack();

    public StringBuilderUndo(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        snapshot();
    }

    public void undo() {
        if (stack.size() <= 1) {
            return;
        }

        stack.pop();
        stringBuilder.setLength(0);
        stringBuilder.append(stack.peek().getState());
    }

    private void snapshot() {
        stack.push(new StringBuilberMemento(stringBuilder.toString()));
    }

    public StringBuilderUndo append(String string) {
        stringBuilder.append(string);
        snapshot();
        return this;
    }

    public StringBuilderUndo reverse() {
        stringBuilder.reverse();
        snapshot();
        return this;
    }

    public StringBuilderUndo delete(int start, int end) {
        stringBuilder.delete(start, end);
        snapshot();
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

}
