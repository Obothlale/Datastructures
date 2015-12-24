package co.za.obothlale.kganane.stacks.use_circularlinkedlist.singular;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;
import co.za.obothlale.kganane.linkedlist.circular.singular.CircularLinkedList;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class Stack<T extends Comparable<? super T>> {

    private CircularLinkedList<T> circularLinkedList;

    public Stack(){
        circularLinkedList = new CircularLinkedList<T>();
    }

    public void push(T data) {
        circularLinkedList.addToHead(data);
    }

    public T pop(){
        return circularLinkedList.deleteFromHead();
    }

    public String print() {
        return circularLinkedList.print();
    }

    public boolean isEmpty() {
        return circularLinkedList.isEmpty();
    }

    public T peek() {
        return circularLinkedList.getHead();
    }

    public T peekBottom() {
        return circularLinkedList.getTail();
    }

    public T peekAtIndex(int index) throws CircularLinkedListOutOfBounds {
        return circularLinkedList.get(index);
    }
}
