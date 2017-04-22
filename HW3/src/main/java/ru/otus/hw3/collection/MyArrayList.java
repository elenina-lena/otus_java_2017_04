package ru.otus.hw3.collection;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_LIST_SIZE = 10;
    private Object[] elements = {};
    private int elementsCount;

    public MyArrayList() {
        this(DEFAULT_LIST_SIZE);
    }

    public MyArrayList(int length) {
        elements = new Object[length];
        elementsCount = 0;
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, elementsCount);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        resize();

        elements[elementsCount] = e;
        elementsCount += 1;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean isNullObject = isNullObject(o);
        boolean isRemoved = false;

        if (!contains(o))
            return isRemoved;

        for (int i = 0; i < elementsCount; i++){
            boolean isNullElement = isNullObject(elements[i]);

            if (!isRemoved && ((isNullElement && isNullObject) || (!isNullElement && elements[i].equals(o)))){
                 isRemoved = true;
            } else if (isRemoved) {
                elements[i - 1] = elements[i];
            }
        }

        if (isRemoved){
            elementsCount--;
        }

        return isRemoved;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_LIST_SIZE];
        elementsCount = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

        Object oldItem = elements[index];
        elements[index] = element;

        return (E) oldItem;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        resize();

        Object[] copy = Arrays.copyOfRange(elements, index + 1, elementsCount);
        elements[index] = element;

        for (int i = 0; i < copy.length; i++) {
                elements[i + index ] = copy[i];
        }

        elementsCount++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        resize();

        Object removedElement = null;
        boolean isRemoved = false;

        for (int i = 0; i < elementsCount; i++){
            if (i == index){
                removedElement = elements[i];
                elements[i] = null;
                isRemoved = true;
            } else if (isRemoved){
                elements[i - 1] = elements[i];
            }
        }

        if (isRemoved){
            elementsCount--;
        }

        return (E) removedElement;
    }

    @Override
    public int indexOf(Object o) {
        boolean isNullObject = isNullObject(o);

        for (int i = 0; i < elementsCount; i++) {
            boolean isNullElement = isNullObject(elements[i]);

            if ((isNullElement && isNullObject) || (!isNullElement && elements[i].equals(o))) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        boolean isNullObject = isNullObject(o);

        for (int i = elements.length - 1; i >= 0; i--) {
            boolean isNullElement = isNullObject(elements[i]);

            if ((isNullElement && isNullObject) || (!isNullElement && elements[i].equals(o))) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private boolean isNullObject(Object object){
        return object == null;
    }

    private void resize() {
        if (elementsCount != elements.length) {
            return;
        }

        int newLength = elements.length * 2;
        elements = Arrays.copyOf(elements, newLength);
    }

    private void checkIndex(int index){
        if (index < 0 || index >= elementsCount) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private class MyListIterator implements ListIterator<E> {
        int currentIndex = 0;
        int lastElementIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < elementsCount;
        }

        @Override
        public E next() {
            Object element = elements[currentIndex];
            lastElementIndex = currentIndex;

            currentIndex++;

            return (E) element;
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        @Override
        public E previous() {
            Object element = elements[currentIndex];
            lastElementIndex = currentIndex;

            currentIndex--;

            return (E) element;
        }

        @Override
        public int nextIndex() {
            if (hasNext())
                return currentIndex + 1;

            return - 1;
        }

        @Override
        public int previousIndex() {
            if (hasPrevious())
                return currentIndex - 1;

            return -1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E element) {
            MyArrayList.this.checkIndex(lastElementIndex);

            MyArrayList.this.set(lastElementIndex, element);
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}


