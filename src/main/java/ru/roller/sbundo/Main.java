package ru.roller.sbundo;

public class Main {
    public static void main(String[] args) {
        StringBuilderUndo test = new StringBuilderUndo(new StringBuilder());

        test.append("Тралла").append("лейло").append("тралала");

        System.out.println(test.toString());
        test.undo();
        System.out.println(test.toString());
        test.undo();
        System.out.println(test.toString());
        test.undo();
        System.out.println(test.toString());

    }
}