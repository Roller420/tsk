package ru.roller.CollectionsTask2;

import java.util.HashMap;
import java.util.Map;

public class Task2 {

    public static <T> Map<T, Integer> mapToMap(T[] array) {
        Map<T, Integer> result = new HashMap<>();

        for (T element : array) {
            Integer count = elementCounter(array, element);
            result.put(element, count);
        }

        return result;
    }

    public static <T> Integer elementCounter(T[] array, T element) {
        int counter = 0;

        for(int i = 0; i < array.length; i++) {
                if (array[i].equals(element))
                    counter++;
        }
        return counter;
    }
}
