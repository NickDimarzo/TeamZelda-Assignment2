import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

import utilities.ListADT;

public class MyArrayListTests {

     private ListADT<Object> list;

    @BeforeEach
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testClear() {
        list.add(1);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testAddAtIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(1, 1);
        });
        assertTrue(list.add(0, 1));
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        assertThrows(NullPointerException.class, () -> {
            list.add(1, null);
        });
    }

    @Test
    public void testAdd() {
        assertTrue(list.add(1));
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        assertThrows(NullPointerException.class, () -> {
            list.add(null);
        });
    }

    @Test
    public void testAddAll() {
        ListADT<Object> toAdd = new MyArrayList<>();
        toAdd.add(1);
        toAdd.add(2);

        assertTrue(list.addAll(toAdd));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));

        assertThrows(NullPointerException.class, () -> {
            list.addAll(null);
        });
    }

    @Test
    public void testGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });

        list.add(1);
        assertEquals(1, list.get(0));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });
    }

    @Test
    public void testRemove() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });

        list.add(1);
        assertEquals(1, list.remove(0));
        assertEquals(0, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

    @Test
    public void testRemoveElement() {
        assertNull(list.remove(1));

        list.add(1);
        assertEquals(1, list.remove(1));
        assertEquals(0, list.size());

        assertThrows(NullPointerException.class, () -> {
            list.remove(null);
        });
    }

    @Test
    public void testSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(0, 1);
        });

        list.add(1);
        assertEquals(1, list.set(0, 2));
        assertEquals(2, list.get(0));

        assertThrows(NullPointerException.class, () -> {
            list.set(0, null);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(1, 3);
        });
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());

        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        assertFalse(list.contains(1));

        list.add(1);
        assertTrue(list.contains(1));

        assertThrows(NullPointerException.class, () -> {
            list.contains(null);
        });
    }

    @Test
    public void testToArray() {
        assertThrows(NullPointerException.class, () -> {
            list.toArray(null);
        });

        list.add(1);
        Object[] array = new Object[list.size()];
        array = list.toArray(array);
        assertEquals(1, array[0]);
        assertEquals(1, array.length);

        list.add(2);
        array = new Object[list.size()];
        array = list.toArray(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(2, array.length);
    }

    @Test
    public void testToArrayWithoutParameter() {
        Object[] array = list.toArray();
        assertEquals(0, array.length);

        list.add(1);
        array = list.toArray();
        assertEquals(1, array[0]);
        assertEquals(1, array.length);

        list.add(2);
        array = list.toArray();
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(2, array.length);
    }

    @Test
    public void testIterator() {
        list.add(1);
        list.add(2);
        Iterator<Object> iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertFalse(iterator.hasNext());
    }

}