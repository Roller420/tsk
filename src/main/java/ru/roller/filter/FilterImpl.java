package ru.roller.filter;

import ru.roller.filter.interfaces.Filter;

public class FilterImpl implements Filter<Integer> {
    @Override
    public Integer apply(Integer o) {
        return o + 100;
    }

    public static void main(String[] args) {
        Integer[] testArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        FilterImpl test = new FilterImpl();

        Integer[] testResult = FilterFunc.filter(testArray, test);

        for (Integer i : testResult) {
            System.out.println(i);
        }
    }
}
