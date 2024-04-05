import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignment2TeamZelda.MyDLL;
import utilities.Iterator;
import utilities.ListADT;

public class MyDLLTest {

    private ListADT<String> myList;

    @Before
    public void setUp() {
        myList = new MyDLL<>();
    }

    @Test
    public void testAdd() {
        assertTrue(myList.isEmpty());
        myList.add("Item 1");
        assertFalse(myList.isEmpty());
        assertEquals(1, myList.size());
        assertEquals("Item 1", myList.get(0));
    }

    @Test
    public void testAddAtIndex() {
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add(1, "Item 3");
        assertEquals(3, myList.size());
        assertEquals("Item 1", myList.get(0));
        assertEquals("Item 3", myList.get(1));
        assertEquals("Item 2", myList.get(2));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullElement() {
        myList.add(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexOutOfBounds() {
        myList.add(1, "Item 1");
    }

    @Test
    public void testRemoveAtIndex() {
        myList.add("Item 1");
        myList.add("Item 2");
        String removedItem = myList.remove(0);
        assertEquals(1, myList.size());
        assertEquals("Item 1", removedItem);
        assertFalse(myList.contains("Item 1"));
    }

    @Test
    public void testRemoveElement() {
        myList.add("Item 1");
        assertTrue(myList.contains("Item 1"));
        String removedItem = myList.remove("Item 1");
        assertNull(myList.remove("Item 1"));
        assertEquals("Item 1", removedItem);
        assertFalse(myList.contains("Item 1"));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullElement() {
        myList.remove(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexOutOfBounds() {
        myList.remove(0);
    }

    @Test
    public void testSize() {
        assertEquals(0, myList.size());
        myList.add("Item 1");
        assertEquals(1, myList.size());
        myList.clear();
        assertEquals(0, myList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myList.isEmpty());
        myList.add("Item 1");
        assertFalse(myList.isEmpty());
        myList.clear();
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testContains() {
        assertFalse(myList.contains("Item 1"));
        myList.add("Item 1");
        assertTrue(myList.contains("Item 1"));
    }

    @Test
    public void testSet() {
        myList.add("Item 1");
        myList.add("Item 2");
        assertEquals("Item 1", myList.set(0, "New Item"));
        assertEquals("New Item", myList.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullElement() {
        myList.add("Item 1");
        myList.set(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexOutOfBounds() {
        myList.set(0, "Item 1");
    }

    @Test
    public void testToArray() {
        myList.add("Item 1");
        myList.add("Item 2");
        Object[] array = myList.toArray();
        assertEquals(2, array.length);
        assertEquals("Item 1", array[0]);
        assertEquals("Item 2", array[1]);
    }

    @Test
    public void testToArrayWithSpecifiedArray() {
        myList.add("Item 1");
        myList.add("Item 2");
        String[] array = myList.toArray(new String[myList.size()]);
        assertEquals(2, array.length);
        assertEquals("Item 1", array[0]);
        assertEquals("Item 2", array[1]);
    }

    @Test(expected = NullPointerException.class)
    public void testToArrayWithNullArray() {
        myList.toArray(null);
    }

    @Test
    public void testAddAll() {
        ListADT<String> otherList = new MyDLL<>();
        otherList.add("Item 1");
        otherList.add("Item 2");
        assertTrue(myList.isEmpty());
        myList.addAll(otherList);
        assertFalse(myList.isEmpty());
        assertEquals(2, myList.size());
        assertEquals("Item 1", myList.get(0));
        assertEquals("Item 2", myList.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllWithNullCollection() {
        myList.addAll(null);
    }

    @Test
    public void testIterator() {
        myList.add("Item 1");
        myList.add("Item 2");
        Iterator<String> iterator = myList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Item 1", iterator.next());
        assertEquals("Item 2", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
