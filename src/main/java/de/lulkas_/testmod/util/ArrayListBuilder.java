package de.lulkas_.testmod.util;

import java.util.ArrayList;

public class ArrayListBuilder<T> {

    private ArrayList<T> values = new ArrayList<>();

    public int size() {
        return values.size();
    }

    public boolean contains(T object) {
        return values.contains(object);
    }

    public ArrayListBuilder<T> set(int index, T object) {
        values.set(index, object);
        return this;
    }

    public T get(int index) {
        return values.get(index);
    }

    public ArrayListBuilder<T> add(T object) {
        values.add(object);
        return this;
    }

}
