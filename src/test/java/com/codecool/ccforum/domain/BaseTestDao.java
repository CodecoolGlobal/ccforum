package com.codecool.ccforum.domain;

import com.codecool.ccforum.domain.entities.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseTestDao<T extends Entity> {

    private static long nextId = 1;

    private final List<T> items = new ArrayList<>();

    public void save(T entity) {
        if (entity.getId() == 0) {
            // insert
            entity.setId(nextId++);
            this.items.add(entity);
        } else {
            // update
            int index = indexOf(entity.getId());
            if (index < 0) {
                throw new IllegalArgumentException();
            }
            items.add(index, entity);
        }
    }

    public List<T> find(Predicate<T> predicate) {
        List<T> res = new ArrayList<>();
        for (T entity : items) {
            if (predicate.test(entity)) {
                res.add(entity);
            }
        }
        return res;
    }

    public T findById(long id) {
        List<T> res = find((e) -> e.getId() == id);
        if (res.size() > 0) {
            return res.get(0);
        }
        return null;
    }

    private int indexOf(long id) {
        for (int i = 0; i < items.size(); i++) {
            T entity = items.get(i);
            if (entity.getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
