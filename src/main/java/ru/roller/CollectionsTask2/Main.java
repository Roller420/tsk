package ru.roller.CollectionsTask2;

import java.util.HashMap;
import java.util.Map;

import static ru.roller.CollectionsTask2.Task2.*;

public class Main {
    public static void main(String[] args) {
        String [] testArray = {"KFC", "Teremok", "Subway", "KFC", "KFC", "Teremok", "Subway", "KFC", "Subway", "KFC",
                               "McDonalds"};

        Map<String, Integer> result = mapToMap(testArray);

        System.out.println(result);
    }
}