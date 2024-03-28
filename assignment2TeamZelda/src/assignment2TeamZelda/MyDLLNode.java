package assignment2TeamZelda;

public class MyDLLNode<E> {

    private E element;
    private MyDLLNode<E> next;
    private MyDLLNode<E> prev;

    public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public MyDLLNode(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    public MyDLLNode<E> getPrev() {
        return prev;
    }

    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
}
