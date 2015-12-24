package co.za.obothlale.kganane.stacks.use_doublylinkedlist;

import co.za.obothlale.kganane.exceptions.DoublyLinkedListOutOfBounds;
import co.za.obothlale.kganane.linkedlist.doubly.DoublyLinkedList;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class Stack<T extends Comparable<? super T>> {

    private DoublyLinkedList<T> doublyLinkedList;

    public Stack(){
        doublyLinkedList = new DoublyLinkedList<T>();
    }

    public void push(T data) {
        doublyLinkedList.addToHead(data);
    }

    public T pop(){
        return doublyLinkedList.deleteFromHead();
    }

    public String print() {
        return doublyLinkedList.printStartFromHead();
    }

    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    public T peek() {
        return doublyLinkedList.getHead();
    }

    public T peekBottom() {
        return doublyLinkedList.getTail();
    }

    public T peekAtIndex(int index) throws DoublyLinkedListOutOfBounds {
        return doublyLinkedList.get(index);
    }
}
