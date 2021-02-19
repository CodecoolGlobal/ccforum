package com.codecool.ccforum.domain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LimitedListTest {

    @Test
    public void testAdd() {
        LimitedList<Integer> list = new LimitedList<>(10);
        list.add(3);
        assertEquals(3, (int) list.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        LimitedList<Integer> list = new LimitedList<>(10);
        list.add(null);
    }

    @Test
    public void testLimitSaved() {
        LimitedList<Integer> list = new LimitedList<>(500);
        assertEquals(500, list.limit());
    }

    @Test
    public void testMinLimit() {
        LimitedList<Integer> list = new LimitedList<>(1);
        assertEquals(1, list.limit());
    }

    @Test
    public void testMaxLimit() {
        LimitedList<Integer> list = new LimitedList<>(1000);
        assertEquals(1000, list.limit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinLimitWrong() {
        LimitedList<Integer> list = new LimitedList<>(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxLimitWrong() {
        LimitedList<Integer> list = new LimitedList<>(1001);
    }

    @Test
    public void testLimit() {
        int limit = 10;
        LimitedList<Integer> list = new LimitedList<>(limit);
        for (int i = 1; i < 100; i++) {
            list.add(i);
            assertEquals(i > limit ? limit : i, list.size());
            assertEquals(limit, list.limit());
            assertEquals(i, (int)list.get(list.size() - 1));
            for (int j = 0; j < (i > limit ? limit : i); j++) {
                int expected = j + 1;
                if (i > limit) {
                    expected = i - (limit - j - 1);
                }
                assertEquals(expected, (int)list.get(j));
            }
            List<Integer> all = list.getAll();
            assertEquals(i > limit ? limit : i, all.size());
            for (int j = 0; j < (i > limit ? limit : i); j++) {
                int expected = j + 1;
                if (i > limit) {
                    expected = i - (limit - j - 1);
                }
                assertEquals(expected, (int)all.get(j));
            }
        }
    }

    @Test
    public void testAddInnerList() {
        LimitedList<Integer> list = new LimitedList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.getAll().add(5);

        assertEquals(3, list.size());
    }


}
