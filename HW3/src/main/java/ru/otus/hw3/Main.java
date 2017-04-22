package ru.otus.hw3;

import ru.otus.hw3.collection.MyArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating an empty list");
        List<Integer> myList = new MyArrayList<>();
        printSizeInfo(myList);

        System.out.println("Adding elements to list");
        myList.add(new Integer(1000));
        myList.add(new Integer(2));
        myList.add(new Integer(4545345));
        printSizeInfo(myList);
        printList(myList);

        System.out.println("Copy list");
        List<Integer> newList = getNewList();
        Collections.copy(myList, newList);
        printList(myList);

        System.out.println("Removing element");
        myList.remove(new Integer(600));

        System.out.println("Adding all elements of array to list");
        Collections.addAll(myList, new Integer[]{10, 9, 8});
        printList(myList);

        System.out.println("Sorting list");
        Collections.sort(myList);
        printList(myList);

        System.out.println("Reverse list");
        Collections.reverse(myList);
        printList(myList);
    }

    private static void printSizeInfo(List list){
        System.out.println(String.format("List is %s", list.isEmpty() ? "empty" : "not empty") );
        System.out.println(String.format("List contains %d elements", list.size()));
        System.out.println();
    }

    private static void printList(List list){
        System.out.println("Elements of list:");

        for(Object item : list){
            System.out.println(item);
        }

        System.out.println();
    }

    private static List<Integer> getNewList(){
        List<Integer> list = new MyArrayList<>();

        for (int i = 300; i <= 900; i += 300) {
            list.add(i);
        }

        return list;
    }
}
