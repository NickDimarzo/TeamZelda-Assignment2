package assignment2TeamZelda;

import java.util.Arrays;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

/**
 * MyDLL is a class representing a doubly linked list implementation
 * that implements the ListADT interface.
 *
 * @param <E> the type of elements stored in the doubly linked list
 */
public class MyDLL<E> implements ListADT<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 442125982517767616L;
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;
	private int size;

	public MyDLL() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Adds the specified element to the end of this list.
	 *
	 * @param toAdd the element to be added to this list
	 * @return true if the element is successfully added
	 * @throws NullPointerException      if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {

		if (toAdd == null) {
			throw new NullPointerException("Cannot add a null element");
		}
		MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}

		size++;
		return true;
	}

	/**
	 * Adds the specified element at the specified position in this list.
	 *
	 * @param index the index at which the specified element is to be inserted
	 * @param toAdd the element to be inserted
	 * @return true if the element is successfully added at the specified position
	 * @throws NullPointerException      if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {

		if (toAdd == null) {
			throw new NullPointerException("Cannot add a null element");
		}

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}

		if (index == size) {
			return add(toAdd);
		}

		MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

		if (index == 0) {
			newNode.setNext(head);
			if (head != null) {
				head.setPrev(newNode);
			}
			head = newNode;
		} else {
			MyDLLNode<E> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			newNode.setPrev(current);
			current.getNext().setPrev(newNode);
			current.setNext(newNode);
		}

		size++;
		return true;
	}

	/**
	 * Adds all elements from the specified list to this list.
	 *
	 * @param toAdd the list containing elements to be added to this list
	 * @return true if all elements are successfully added
	 * @throws NullPointerException if the specified list is null
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException("Cannot add a null list");
		}

		Iterator<? extends E> iterator = toAdd.iterator();

		while (iterator.hasNext()) {
			add(iterator.next());
		}

		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}
		MyDLLNode<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getElement();
	}

	/**
	 * Removes the element at the specified index in this list.
	 *
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}

		MyDLLNode<E> removedNode;
		if (size == 1) {
			removedNode = head;
			head = null;
			tail = null;
		} else if (index == 0) {
			removedNode = head;
			head = head.getNext();
			head.setPrev(null);
		} else if (index == size - 1) {
			removedNode = tail;
			tail = tail.getPrev();
			tail.setNext(null);
		} else {
			MyDLLNode<E> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			removedNode = current;
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
		}
		size--;
		return removedNode.getElement();
	}

	/**
	 * Removes the first occurrence of the specified element from this list.
	 *
	 * @param toRemove the element to be removed from this list
	 * @return true if the element is successfully removed
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException("Element to remove is null.");
		}
		MyDLLNode<E> current = head;
		while (current != null) {
			if (current.getElement().equals(toRemove)) {
				if (current == head) {
					head = current.getNext();
					if (head != null) {
						head.setPrev(null);
					}
				} else if (current == tail) {
					tail = current.getPrev();
					if (tail != null) {
						tail.setNext(null);
					}
				} else {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
				}
				size--;
				return toRemove;
			}
			current = current.getNext();
		}
		return null;
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 *                 The index of the element to replace.
	 * @param toChange
	 *                 Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException
	 *                                   If the specified element is
	 *                                   <code>null</code> and the
	 *                                   list implementation does not support having
	 *                                   <code>null</code> elements.
	 * @throws IndexOutOfBoundsException
	 *                                   If the index is out of range:
	 *                                   i.e.
	 *                                   (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {

		if (toChange == null) {
			throw new NullPointerException("Cannot set a null element");
		}

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}

		MyDLLNode<E> newNode = new MyDLLNode<>(toChange);

		if (index == 0) {
			newNode.setNext(head);
			if (head != null) {
				head.setPrev(newNode);
			}
			head = newNode;
		} else {
			MyDLLNode<E> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			newNode.setPrev(current);
			if (current.getNext() != null) {
				current.getNext().setPrev(newNode);
			}
			if (current.getPrev() != null) {
				current.getPrev().setNext(newNode);
			}
		}

		size++;

		return toChange;
	}

	/**
	 * @param an element
	 * @return true if element exists in DLL, false otherwise
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException("Cannot find a null element");
		}

		Iterator<E> iterator = iterator();

		while (iterator.hasNext()) {
			E element = iterator.next();
			if (element == toFind || element.equals(toFind)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence
	 * 
	 * @param toHold
	 *               The array into which the elements of this list are to be
	 *               stored, if it is big enough; otherwise, a new array of the
	 *               same runtime type is allocated for this purpose.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException
	 *                              If the specified array is null.
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException("Array to hold elements is null.");
		}
		if (toHold.length < size) {
			toHold = Arrays.copyOf(toHold, size);
		}

		int index = 0;
		Iterator<E> iterator = iterator();

		while (iterator.hasNext()) {
			toHold[index++] = iterator.next();
		}
		return toHold;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Array
	 * 
	 * @return An array containing all of the elements in this list in proper
	 *         sequence.
	 */
	@Override
	public Object[] toArray() {
		Object[] anArray = new Object[size];
		int index = 0;
		Iterator<E> iterator = iterator();

		while (iterator.hasNext()) {
			anArray[index++] = iterator.next();
		}
		return anArray;
	}

	/**
	 * @return true if the DLL is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @return the number of elements in DLL
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Clears all elements from this list.
	 */
	@Override
	public void clear() {
		MyDLLNode<E> current = head;

		while (current != null) {
			MyDLLNode<E> next = current.getNext();
			current.setNext(null);
			current.setPrev(null);
			current = next;
		}
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 *
	 * @return an iterator over the elements in this list
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyDLLIterator();
	}

	/**
	 * This class implements an iterator for the elements in a DLL.
	 */
	public class MyDLLIterator implements Iterator<E> {

		private MyDLLNode<E> current = head;

		public MyDLLIterator() {

			current = head;
		}

		/**
		 * Checks whether there are more elements in the queue to iterate over.
		 * 
		 * @return true if there are more elements, false otherwise
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Returns the next element in the queue.
		 * 
		 * @return the next element in the queue
		 * @throws NoSuchElementException if there are no more elements to iterate over
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException("No more elements in this DLL");
			}
			E element = current.getElement();
			current = current.getNext();

			return element;
		}
	}

}
