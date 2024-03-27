package utilities;

import java.util.ArrayList;

import utilities.ListADT;

public class MyArrayList<E> implements ListADT<E> {
    private ArrayList<E> list;

    public MyArrayList() {
        list = new ArrayList<>();
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Throws NullPointerException if the specified element is null.
     * Throws IndexOutOfBoundsException if the index is out of range.
     *
     * @param index index at which the specified element is to be inserted
     * @param toAdd element to be inserted
     * @return true (as specified by Collection.add(E))
     * @throws NullPointerException      if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Appends the specified element to the end of this list.
     * Throws NullPointerException if the specified element is null.
     *
     * @param toAdd element to be appended to this list
     * @return true (as specified by Collection.add(E))
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The specified element is null.");
        }
        return list.add(toAdd);
    }

    /**
     * Appends all of the elements in the specified collection to the end of this
     * list,
     * in the order that they are returned by the specified collection's iterator.
     * Throws NullPointerException if the specified collection is null.
     *
     * @param toAdd collection containing elements to be added to this list
     * @return true (as specified by Collection.addAll(Collection))
     * @throws NullPointerException if the specified collection is null
     */
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

    /**
     * Returns the element at the specified position in this list.
     * Throws IndexOutOfBoundsException if the index is out of range.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("The index is out of range.");
        }
        return list.get(index);
    }

    /**
     * Removes the element at the specified position in this list.
     * Throws IndexOutOfBoundsException if the index is out of range.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("The index is out of range.");
        }
        return list.remove(index);
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it
     * is present.
     * If the list does not contain the element, it is unchanged.
     * Throws NullPointerException if the specified element is null.
     *
     * @param toRemove element to be removed from this list, if present
     * @return the removed element, or null if the list does not contain the element
     * @throws NullPointerException if the specified element is null
     */
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

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * Throws NullPointerException if the specified element is null.
     * Throws IndexOutOfBoundsException if the index is out of range.
     *
     * @param index    index of the element to replace
     * @param toChange element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws NullPointerException      if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns true if this list contains the specified element.
     * Throws NullPointerException if the specified element is null.
     *
     * @param toFind element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("The specified element is null.");
        }
        return list.contains(toFind);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence
     * (from first to last element); the runtime type of the returned array is that
     * of the specified array.
     * Throws NullPointerException if the specified array is null.
     *
     * @param toHold the array into which the elements of this list are to be stored
     * @return an array containing all of the elements in this list
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("The specified array is null.");
        }
        return list.toArray(toHold);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence
     * (from first to last element).
     *
     * @return an array containing all of the elements in this list
     */
    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

}