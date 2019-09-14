package org.bon.api.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Tommi
 * Date: 14/09/2019
 * Time: 1.51
 */

public abstract class ModSafeList<E> extends ArrayList<E> {

    public ModSafeList() {
        super();
    }

    @Override
    public Object clone() {
        throw new UnsupportedOperationException("Cloning this container is not a safe operation.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Array of this container is not a safe operation.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Array of this container is not a safe operation.");
    }

    @Override
    public abstract E set(int index, E element);

    @Override
    public abstract boolean add(E e);

    @Override
    public abstract void add(int index, E element);

    @Override
    public abstract E remove(int index);

    @Override
    public abstract boolean remove(Object o);

    @Override
    public abstract void clear();

    @Override
    public abstract boolean addAll(Collection<? extends E> c);

    @Override
    public abstract boolean addAll(int index, Collection<? extends E> c);

    @Override
    public abstract boolean removeAll(Collection<?> c);

    @Override
    public abstract List<E> subList(int fromIndex, int toIndex);

    @Override
    public abstract void replaceAll(UnaryOperator<E> operator);

    @Override
    public boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }
}
