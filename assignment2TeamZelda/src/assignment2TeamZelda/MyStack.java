package assignment2TeamZelda;

import java.util.EmptyStackException;
import utilities.Iterator;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E> {
    private MyArrayList<E> list;

    /**
     * Constructs an empty stack.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /**
     * Adds the specified element to the top of this stack.
     *
     * @param toAdd the element to be added to this stack
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException();
        }
        list.add(toAdd);
    }

    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return the element at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    @Override
    public E pop() throws EmptyStackException {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    /**
     * Returns the element at the top of this stack without removing it.
     *
     * @return the element at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    @Override
    public E peek() throws EmptyStackException {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    /**
     * Removes all elements from this stack.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Checks if this stack is empty.
     *
     * @return true if this stack contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns an array containing all of the elements in this stack.
     *
     * @return an array containing all of the elements in this stack
     */
    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * Returns an array containing all of the elements in this stack;
     * the runtime type of the returned array is that of the specified array.
     *
     * @param holder the array into which the elements of this stack are to be stored
     * @return an array containing all of the elements in this stack
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return list.toArray(holder);
    }

    /**
     * Checks if this stack contains the specified element.
     *
     * @param toFind the element to be checked for containment in this stack
     * @return true if this stack contains the specified element, false otherwise
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return list.contains(toFind);
    }

    /**
     * Searches for the specified element in this stack and returns its position
     * relative to the top of the stack.
     *
     * @param toFind the element to be searched for in this stack
     * @return the 1-based position of the element from the top of the stack,
     *         or -1 if the element is not found in the stack
     */
    @Override
    public int search(E toFind) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals(toFind)) {
                return list.size() - i;
            }
        }
        return -1;
    }

    /**
     * Returns an iterator over the elements in this stack.
     *
     * @return an iterator over the elements in this stack
     */
    @Override
    public Iterator<E> iterator() {
        return iterator();
    }

    /**
     * Checks if this stack is equal to the specified stack.
     *
     * @param that the stack to be compared for equality with this stack
     * @return true if the specified stack is equal to this stack, false otherwise
     */
    @Override
    public boolean equals(StackADT<E> that) {
        if (this.size() != that.size()) {
            return false;
        }
        Object[] thisArray = this.toArray();
        Object[] thatArray = that.toArray();
        for (int i = 0; i < thisArray.length; i++) {
            if (!thisArray[i].equals(thatArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    @Override
    public int size() {
        return list.size();
    }
}