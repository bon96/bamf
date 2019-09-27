package org.bon.util;

import java.util.*;

/**
 * Tommi
 * Date: 14/09/2019
 * Time: 1.51
 */

public abstract class ModSafeList<E> implements List<E> {

    private List<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public abstract void onAdd(E e);

    public boolean add(E e) {
        return list.add(e);
    }

    public abstract void onRemove(E e);

    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        for (E e : list) {
            onRemove(e);
        }
        list.clear();
    }

    public E get(int index) {
        return list.get(index);
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    private class Itr implements Iterator<E> {
        private int current;

        @Override
        public E next() {
            if (current >= size()) {
                throw new NoSuchElementException();
            }
            return list.get(current++);
        }

        @Override
        public boolean hasNext() {
            return current < size();
        }
    }
}
