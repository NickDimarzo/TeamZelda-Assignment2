import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import assignment2TeamZelda.MyStack;
import utilities.Iterator;
import utilities.StackADT;

public class MyStackTest {

    private StackADT<String> myStack;

    @Before
    public void setUp() {
        myStack = new MyStack<>();
    }

    @Test
    public void testPush() {
        assertTrue(myStack.isEmpty());
        myStack.push("Item 1");
        assertFalse(myStack.isEmpty());
        assertEquals(1, myStack.size());
        assertEquals("Item 1", myStack.peek());
    }

    @Test
    public void testPop() {
        myStack.push("Item 1");
        myStack.push("Item 2");
        assertEquals("Item 2", myStack.pop());
        assertEquals(1, myStack.size());
        assertEquals("Item 1", myStack.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        myStack.pop();
    }

    @Test
    public void testPeek() {
        myStack.push("Item 1");
        myStack.push("Item 2");
        assertEquals("Item 2", myStack.peek());
        assertEquals(2, myStack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack() {
        myStack.peek();
    }

    @Test
    public void testClear() {
        myStack.push("Item 1");
        myStack.push("Item 2");
        myStack.clear();
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myStack.isEmpty());
        myStack.push("Item 1");
        assertFalse(myStack.isEmpty());
        myStack.pop();
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testToArray() {
        myStack.push("Item 1");
        myStack.push("Item 2");
        Object[] array = myStack.toArray();
        assertEquals(2, array.length);
        assertEquals("Item 2", array[0]);
        assertEquals("Item 1", array[1]);
    }

    @Test
    public void testToArrayWithSpecifiedArray() {
        myStack.push("Item 1");
        myStack.push("Item 2");
        String[] array = myStack.toArray(new String[myStack.size()]);
        assertEquals(2, array.length);
        assertEquals("Item 2", array[0]);
        assertEquals("Item 1", array[1]);
    }

    @Test(expected = NullPointerException.class)
    public void testToArrayWithNullArray() {
        myStack.toArray(null);
    }

    @Test
    public void testContains() {
        myStack.push("Item 1");
        myStack.push("Item 2");
        assertTrue(myStack.contains("Item 1"));
        assertFalse(myStack.contains("Item 3"));
    }

    @Test
    public void testSearch() {
        myStack.push("Item 1");
        myStack.push("Item 2");
        assertEquals(1, myStack.search("Item 2"));
        assertEquals(2, myStack.search("Item 1"));
        assertEquals(-1, myStack.search("Item 3"));
    }

    @Test
    public void testEquals() {
        StackADT<String> otherStack = new MyStack<>();
        assertFalse(myStack.equals(otherStack));
        myStack.push("Item 1");
        otherStack.push("Item 1");
        assertTrue(myStack.equals(otherStack));
    }

    @Test
    public void testSize() {
        assertEquals(0, myStack.size());
        myStack.push("Item 1");
        assertEquals(1, myStack.size());
        myStack.push("Item 2");
        assertEquals(2, myStack.size());
        myStack.pop();
        assertEquals(1, myStack.size());
    }

    @Test
    public void testIterator() {
        myStack.push("Item 1");
        myStack.push("Item 2");
        Iterator<String> iterator = myStack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Item 2", iterator.next());
        assertEquals("Item 1", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
