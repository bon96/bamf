package org.bon.util;

import java.util.*;

/**
 * Tommi
 * Date: 28/09/2019
 * Time: 13.45
 */

public abstract class ModSafeList<E> implements Iterable<E> {

    private List<E> list = new ArrayList<>();

    protected abstract void onAdd(E e);

    protected abstract void onRemove(E e);

    public E get(int index) {
        return list.get(index);
    }

    public boolean add(E e) {
        onAdd(e);
        return list.add(e);
    }

    public boolean remove(int index) {
        return remove(get(index));
    }

    public boolean remove(E e) {
        onRemove(e);
        return list.remove(e);
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean containsAll(Collection<? extends E> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    public boolean removeAll(Collection<? extends E> c) {
        for (E e : c) {
            remove(e);
        }
        return true;
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    public static void main(String[] args) {
    }

    private class Itr implements Iterator<E> {
        private int current;

        @Override
        public E next() {
            if (current >= list.size()) {
                throw new NoSuchElementException();
            }
            return list.get(current++);
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }
    }
}
