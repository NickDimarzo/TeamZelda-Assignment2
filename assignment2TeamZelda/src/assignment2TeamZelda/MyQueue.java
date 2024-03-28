package assignment2TeamZelda;

import java.util.Arrays;
import java.util.NoSuchElementException;

import exception.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

public class MyQueue<E> implements QueueADT<E> {

    /**
     * 
     */
    private static final long serialVersionUID = -5830659200045825140L;

    private static final int DEFAULT_CAPACITY = 10;
    private E[] queueArray;
    private E item;
    private int rear = 0;
    private int size = 0;
    private int front = 0;

    /**
     * Constructs an empty queue with a default capacity.
     */
    @SuppressWarnings("unchecked")
    public MyQueue() {
        queueArray = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * Adds the specified element to the end of the queue.
     * 
     * @param toAdd the element to be added to the queue
     * @throws NullPointerException  if the specified element is null
     * @throws IllegalStateException if the queue is full and cannot accept more
     *                               elements
     */
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot queue a null element");
        }
        if (isFull()) {
            throw new IllegalStateException("Queue is full, cannot enqueue more elements");
        }
        queueArray[rear] = toAdd;
        rear = (rear + 1) % queueArray.length;
        size++;
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
            throw new EmptyQueueException("This queue is empty, dude. Get some peeps here.");
        }
        item = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        size--;
        return item;
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
            throw new EmptyQueueException("This queue is empty, dude. Get some peeps here.");
        }
        item = queueArray[front];
        return item;
    }

    /**
     * Removes all elements from the queue, leaving it empty.
     */
    @Override
    public void dequeueAll() {
        for (int i = 0; i < queueArray.length; i++) {
            try {
                dequeue();
            } catch (EmptyQueueException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Checks whether the queue is empty.
     * 
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in the queue.
     * 
     * @return an iterator over the elements in the queue
     */
    public Iterator<E> iterator() {
        return new MyQueueIterator();
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
            return false; // Sizes are different, queues cannot be equal
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
        Object[] anArray = new Object[size];
        int index = 0;

        for (int i = front; i < front + size; i++) {
            int currentIndex = i % queueArray.length;
            anArray[index++] = queueArray[currentIndex];
        }
        return anArray;
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
        if (holder == null) {
            throw new NullPointerException("This array is too null");
        }
        if (holder.length < size) {
            holder = Arrays.copyOf(holder, size);
        }

        int index = 0;
        for (int i = front; i < front + size; i++) {
            int currentIndex = i % queueArray.length;
            holder[index++] = (E) queueArray[currentIndex]; // Cast to E
        }

        return holder;
    }

    /**
     * Checks whether the queue is full.
     * 
     * @return true if the queue is full, false otherwise
     */
    @Override
    public boolean isFull() {
        return size == queueArray.length;
    }

    /**
     * Returns the number of elements in the queue.
     * 
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This class implements an iterator for the elements in the queue.
     */
    public class MyQueueIterator implements Iterator<E> {
        private int currentIndex;
        private int elementsLeft;

        public MyQueueIterator() {
            currentIndex = front;
            elementsLeft = size;
        }

        /**
         * Checks whether there are more elements in the queue to iterate over.
         * 
         * @return true if there are more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return elementsLeft > 0;
        }

        /**
         * Returns the next element in the queue.
         * 
         * @return the next element in the queue
         * @throws NoSuchElementException if there are no more elements to iterate over
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the queue");
            }
            E element = queueArray[currentIndex];
            currentIndex = (currentIndex + 1) % queueArray.length;
            elementsLeft--;
            return element;
        }
    }

}
