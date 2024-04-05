import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignment2TeamZelda.MyQueue;
import exception.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

public class MyQueueTest {

    private QueueADT<String> myQueue;

    @Before
    public void setUp() {
        myQueue = new MyQueue<>();
    }

    @Test
    public void testEnqueue() {
        assertTrue(myQueue.isEmpty());
        myQueue.enqueue("Item 1");
        assertFalse(myQueue.isEmpty());
        assertEquals(1, myQueue.size());
        assertEquals("Item 1", myQueue.peek());
    }

    @Test
    public void testDequeue() throws EmptyQueueException {
        myQueue.enqueue("Item 1");
        myQueue.enqueue("Item 2");
        assertEquals("Item 1", myQueue.dequeue());
        assertEquals(1, myQueue.size());
        assertEquals("Item 2", myQueue.peek());
    }

    @Test(expected = EmptyQueueException.class)
    public void testDequeueEmptyQueue() throws EmptyQueueException {
        myQueue.dequeue();
    }

    @Test
    public void testPeek() throws EmptyQueueException {
        myQueue.enqueue("Item 1");
        myQueue.enqueue("Item 2");
        assertEquals("Item 1", myQueue.peek());
        assertEquals(2, myQueue.size());
    }

    @Test(expected = EmptyQueueException.class)
    public void testPeekEmptyQueue() throws EmptyQueueException {
        myQueue.peek();
    }

    @Test
    public void testDequeueAll() {
        myQueue.enqueue("Item 1");
        myQueue.enqueue("Item 2");
        myQueue.dequeueAll();
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myQueue.isEmpty());
        myQueue.enqueue("Item 1");
        assertFalse(myQueue.isEmpty());
        myQueue.dequeue();
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void testEquals() {
        QueueADT<String> otherQueue = new MyQueue<>();
        assertFalse(myQueue.equals(otherQueue));
        myQueue.enqueue("Item 1");
        otherQueue.enqueue("Item 1");
        assertTrue(myQueue.equals(otherQueue));
    }

    @Test
    public void testSize() {
        assertEquals(0, myQueue.size());
        myQueue.enqueue("Item 1");
        assertEquals(1, myQueue.size());
        myQueue.enqueue("Item 2");
        assertEquals(2, myQueue.size());
        myQueue.dequeue();
        assertEquals(1, myQueue.size());
    }

    @Test
    public void testToArray() {
        myQueue.enqueue("Item 1");
        myQueue.enqueue("Item 2");
        Object[] array = myQueue.toArray();
        assertEquals(2, array.length);
        assertEquals("Item 1", array[0]);
        assertEquals("Item 2", array[1]);
    }

    @Test
    public void testToArrayWithSpecifiedArray() {
        myQueue.enqueue("Item 1");
        myQueue.enqueue("Item 2");
        String[] array = myQueue.toArray(new String[myQueue.size()]);
        assertEquals(2, array.length);
        assertEquals("Item 1", array[0]);
        assertEquals("Item 2", array[1]);
    }

    @Test(expected = NullPointerException.class)
    public void testToArrayWithNullArray() {
        myQueue.toArray(null);
    }

    @Test
    public void testIterator() {
        myQueue.enqueue("Item 1");
        myQueue.enqueue("Item 2");
        Iterator<String> iterator = myQueue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Item 1", iterator.next());
        assertEquals("Item 2", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
