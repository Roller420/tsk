package ru.roller.filter;

import ru.roller.filter.interfaces.Filter;

public class FilterFunc {

    public static <T> T[] filter(T[] array, Filter<T> filter) {
          T[] result = array;

          for (int i = 0; i < array.length; i++) {
              result[i] = filter.apply(array[i]);
          }
          return result;
    }
}
