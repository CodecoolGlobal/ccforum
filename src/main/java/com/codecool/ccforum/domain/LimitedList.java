package com.codecool.ccforum.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LimitedList<T> {

    private final List<T> list = new ArrayList<>();
    private final int limit;

    public LimitedList(int limit) {
        if (limit < 1 || limit > 1000) {
            throw new IllegalArgumentException("The limit must be between 1 and 1000 inclusive.");
        }
        this.limit = limit;
    }

    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        list.add(element);
        if (list.size() > limit) {
            list.remove(0);
        }
    }

    public int limit() {
        return this.limit;
    }

    public int size() {
        return list.size();
    }

    public T get(int index) {
        return list.get(index);
    }

    public List<T> getAll() {
        return list.stream().collect(Collectors.toList());
    }

    public void clear() {
        list.clear();
    }

}
