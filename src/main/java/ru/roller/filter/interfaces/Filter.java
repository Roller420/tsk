package ru.roller.filter.interfaces;

public interface Filter<T> {
    T apply(T o);
}

