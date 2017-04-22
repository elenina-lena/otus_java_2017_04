package ru.otus.hw3;

import org.junit.Test;
import ru.otus.hw3.collection.MyArrayList;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void testEmpty() {
        List<Integer> list = new MyArrayList<>();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        List<String> list = new MyArrayList<>();

        list.add("one");
        list.add("two");

        assertFalse(list.isEmpty());
    }

    @Test
    public void testListSize(){
        List<String> list = new MyArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals(list.size(), 3);
    }

    @Test
    public void testEmptyListSize(){
        List<String> list = new MyArrayList<>();

        assertEquals(list.size(), 0);
    }

    @Test
    public void testAddElementsToList(){
        List<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertArrayEquals(list.toArray(), new Integer[] { 1, 2, 3});
    }

    @Test
    public void testContains(){
        List<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(1));
    }

    @Test
    public void testNullElementContains(){
        List<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);

        assertTrue(list.contains(null));
    }

    @Test
    public void testNotContains(){
        List<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertFalse(list.contains(10));
    }

    @Test
    public void testClear(){
        List<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(list.size(), 0);
    }

    @Test
    public void testRemoveByObject(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");

        assertFalse(list.remove("Five"));
        assertTrue(list.remove("Two"));

        assertArrayEquals(list.toArray(), new String[]{"One", "Three"});
    }

    @Test
    public void testRemoveNullObject(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add(null);
        list.add("Three");

        assertTrue(list.remove(null));
        assertFalse(list.remove("Two"));

        assertArrayEquals(list.toArray(), new String[]{"One", "Three"});
    }

    @Test
    public void testRemoveByIndex(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove(0);

        assertArrayEquals(list.toArray(), new String[]{"Two", "Three"});
    }

    @Test
    public void testGet(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add(null);

        assertEquals(list.get(0), "One");
        assertEquals(list.get(1), "Two");
        assertEquals(list.get(3), "Four");
        assertEquals(list.get(4), null);
    }

    @Test
    public void testSet(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        assertEquals(list.set(0, new String("New value")), "One");
        assertArrayEquals(list.toArray(), new String[]{"New value","Two", "Three", "Four"});
    }

    @Test
    public void testIndexOf(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        assertEquals(list.indexOf("Four"), 3);
    }

    @Test
    public void testCollectionsAddAll(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        String[] newElements = {"Five", "Six"};
        Collections.addAll(list, newElements);

        assertArrayEquals(list.toArray(), new String[] {
                "One", "Two", "Three", "Four", "Five", "Six"
        });
    }

    @Test
    public void testCollectionsCopy(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        List<String> newElements = new MyArrayList<>();
        newElements.add("Five");
        newElements.add("Six");
        newElements.add("Seven");
        newElements.add("Eight");

        Collections.copy(list, newElements);

        assertArrayEquals(list.toArray(), new String[] {
                "Five", "Six", "Seven", "Eight"
        });
    }

    @Test
    public void testCollectionsSort(){
        List<String> list = new MyArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        Collections.sort(list);

        assertArrayEquals(list.toArray(), new String[] {
                "Four", "One", "Three", "Two"
        });
    }
}
