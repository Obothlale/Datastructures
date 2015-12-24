package co.za.obothlale.kganane.stacks.use_circularlinkedlist.doubly;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;
import co.za.obothlale.kganane.linkedlist.circular.doubly.CircularDoublyLinkedList;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class Stack<T extends Comparable<? super T>> {

    private CircularDoublyLinkedList<T> circularDoublyLinkedList;

    public Stack(){
        circularDoublyLinkedList = new CircularDoublyLinkedList<T>();
    }

    public void push(T data) {
        circularDoublyLinkedList.addToHead(data);
    }

    public T pop(){
        return circularDoublyLinkedList.deleteFromHead();
    }

    public String print() {
        return circularDoublyLinkedList.print();
    }

    public boolean isEmpty() {
        return circularDoublyLinkedList.isEmpty();
    }

    public T peek() {
        return circularDoublyLinkedList.getHead();
    }

    public T peekBottom() {
        return circularDoublyLinkedList.getTail();
    }

    public T peekAtIndex(int index) throws CircularLinkedListOutOfBounds {
        return circularDoublyLinkedList.get(index);
    }
}
