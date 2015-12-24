package co.za.obothlale.kganane.stacks.use_singularlinkedlist;

import co.za.obothlale.kganane.exceptions.SingularLinkedListOutOfBounds;
import co.za.obothlale.kganane.linkedlist.singular.SingularLinkedList;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class Stack<T extends Comparable<? super T>> {

    private SingularLinkedList<T> singularLinkedList;

    public Stack(){
        singularLinkedList = new SingularLinkedList<T>();
    }

    public void push(T data) {
        singularLinkedList.addToHead(data);
    }

    public T pop(){
        return singularLinkedList.deleteFromHead();
    }

    public String print() {
        return singularLinkedList.print();
    }

    public boolean isEmpty() {
        return singularLinkedList.isEmpty();
    }

    public T peek() {
        return singularLinkedList.getHead();
    }

    public T peekBottom() {
        return singularLinkedList.getTail();
    }

    public T peekAtIndex(int index) throws SingularLinkedListOutOfBounds {
        return singularLinkedList.get(index);
    }
}
