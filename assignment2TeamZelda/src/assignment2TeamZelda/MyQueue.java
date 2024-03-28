package assignment2TeamZelda;

import exception.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 * MyQueue is a class representing a queue implementation
 * that implements the QueueADT interface using a doubly linked list.
 *
 * @param <E> the type of elements stored in the queue
 */
public class MyQueue<E> implements QueueADT<E> {

    /**
     * 
     */
    private static final long serialVersionUID = -5830659200045825140L;

    private MyDLL<E> queueList;

    /**
     * Constructs an empty queue.
     */
    public MyQueue() {
        queueList = new MyDLL<>();
    }

    /**
     * Adds the specified element to the end of the queue.
     *
     * @param toAdd the element to be added to the queue
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        queueList.add(toAdd);
    }

    /**
     * Removes and returns the first element in the queue.
     *
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("This queue is empty.");
        }
        return queueList.remove(0);
    }

    /**
     * Returns the first element in the queue without removing it.
     *
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("This queue is empty.");
        }
        return queueList.get(0);
    }

    /**
     * Removes all elements from the queue, leaving it empty.
     */
    @Override
    public void dequeueAll() {
        queueList.clear();

    }

    /**
     * Checks whether the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    /**
     * Returns an iterator over the elements in the queue.
     *
     * @return an iterator over the elements in the queue
     */
    public Iterator<E> iterator() {
        return queueList.iterator();
    }

    /**
     * Compares this queue with another queue for equality.
     *
     * @param that the queue to be compared with this queue
     * @return true if the queues are equal, false otherwise
     */
    @Override
    public boolean equals(QueueADT<E> that) {
        if (this.size() != that.size()) {
            return false;
        }
        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();

        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            E thisElement = thisIterator.next();
            E otherElement = thatIterator.next();

            if (!thisElement.equals(otherElement)) {
                return false;
            }
        }

        return !thisIterator.hasNext() && !thatIterator.hasNext();

    }

    /**
     * Returns an array containing all of the elements in the queue.
     *
     * @return an array containing all of the elements in the queue
     */
    @Override
    public Object[] toArray() {
        return queueList.toArray();
    }

    /**
     * Returns an array containing all of the elements in the queue.
     *
     * @param holder the array into which the elements of the queue are to be stored
     * @return an array containing all of the elements in the queue
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return queueList.toArray(holder);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return queueList.size();
    }

}
