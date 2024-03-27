package utilities;

import java.util.ArrayList;

import utilities.ListADT;

public class MyArrayList<E> implements ListADT<E> {
    private ArrayList<E> list;

    public MyArrayList() {
        list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("The specified element is null.");
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("The index is out of range.");
        }
        list.add(index, toAdd);
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The specified element is null.");
        }
        return list.add(toAdd);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The specified collection is null.");
        }
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("The index is out of range.");
        }
        return list.get(index);
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("The index is out of range.");
        }
        return list.remove(index);
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("The specified element is null.");
        }
        int index = list.indexOf(toRemove);
        if (index != -1) {
            return list.remove(index);
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("The specified element is null.");
        }
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("The index is out of range.");
        }
        return list.set(index, toChange);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("The specified element is null.");
        }
        return list.contains(toFind);
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("The specified array is null.");
        }
        return list.toArray(toHold);
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

}