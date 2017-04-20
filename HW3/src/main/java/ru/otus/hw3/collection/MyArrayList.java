package ru.otus.hw3.collection;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private Object[] data = {};

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean isNullObject = isNullObject(o);

        for (Object item : data){
            boolean isNullElement = isNullObject(item);

            if ((isNullElement && isNullObject) || (!isNullElement && item.equals(o))){
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        Object[] copy = Arrays.copyOf(data, data.length);

        int newLength = copy.length + 1;
        data = new Object[newLength];

        for (int i = 0; i < newLength; i++){
            if (i == copy.length){
                data[i] = e;
            }
            else {
                data[i] = copy[i];
            }
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean isNullObject = isNullObject(o);
        boolean isRemoved = false;

        if (!contains(o))
            return isRemoved;

        Object[] copy = Arrays.copyOf(data, data.length);

        int newLength = copy.length - 1;
        data = new Object[newLength];

        for (int i = 0, j = 0; i < newLength; i++, j++){
            boolean isNullElement = isNullObject(copy[j]);

            if (!isRemoved && ((isNullElement && isNullObject) || (!isNullElement && copy[j].equals(o)))){
                i--;
                isRemoved = true;
            } else {
                data[i] = copy[j];
            }
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
        data = new Object[0];
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return (E) data[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

        Object oldItem = data[index];
        data[index] = element;

        return (E) oldItem;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);

        int newLength = data.length + 1;
        Object[] copy = Arrays.copyOf(data, newLength);
        data = new Object[newLength];

        for (int i = 0; i < newLength; i++) {
            if (i < index){
                data[i] = copy[i];
            }
            else if (i == index) {
                data[i] = element;
            }
            else {
                data[i] = copy[i - 1];
            }
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        Object removedElement = null;
        boolean isRemoved = false;
        int newLength = data.length - 1;

        Object[] copy = Arrays.copyOf(data, data.length);
        data = new Object[newLength];

        for (int i = 0; i <= newLength; i++){
            if (i == index){
                removedElement = copy[i];
                isRemoved = true;
            } else if (isRemoved){
                data[i - 1] = copy[i];
            } else {
                data[i] = copy[i];
            }
        }

        return (E) removedElement;
    }

    @Override
    public int indexOf(Object o) {
        boolean isNullObject = isNullObject(o);

        for (int i = 0; i < data.length; i++) {
            boolean isNullElement = isNullObject(data[i]);

            if ((isNullElement && isNullObject) || (!isNullElement && data[i].equals(o))) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        boolean isNullObject = isNullObject(o);

        for (int i = data.length - 1; i >= 0; i--) {
            boolean isNullElement = isNullObject(data[i]);

            if ((isNullElement && isNullObject) || (!isNullElement && data[i].equals(o))) {
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

    private void checkIndex(int index){
        if (index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private class MyIterator<E> implements Iterator<E> {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < data.length;
        }

        @Override
        public E next() {
            Object element = data[currentIndex];
            currentIndex++;

            return (E) element;
        }
    }

    private class MyListIterator implements ListIterator<E> {
        int currentIndex = 0;
        int lastElementIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < data.length - 1;
        }

        @Override
        public E next() {
            Object element = data[currentIndex];
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
            Object element = data[currentIndex];
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


