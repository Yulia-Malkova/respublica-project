package ru.respublica.utils;

import java.util.Random;

public class RandomEnumGenerator<T extends Enum<T>> {
    private static final Random getRandomEnum = new Random();
    private final T[] values;

    public RandomEnumGenerator(Class<T> e) {
        values = e.getEnumConstants();
    }

    public T randomEnum() {
        return values[getRandomEnum.nextInt(values.length)];
    }
}
