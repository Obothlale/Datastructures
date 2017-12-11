package co.za.obothlale.kganane.linkedlist.circular.doubly;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;

/**
 * Created by Obothlale on 2015-05-06.
 *
 */
public class CircularDoublyLinkedList<T extends Comparable<? super T>> {

    private Node<T> head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    protected void insert(T data) {
        addToTail(data);
    }

    public void addToTail(T data) {
        if (isEmpty()) {
            head = new Node<T>(data);
            head.next = head.prev = head;
        } else {
            Node<T> tmp = head.prev;
            Node<T> node = new Node<T>(data, head, tmp);
            head.prev = node;
            tmp.next = node;
        }
        size++;
    }

    public void addToHead(T data) {
        if (isEmpty()) {
            head = new Node<T>(data);
            head.next = head.prev = head;
        } else {
            Node<T> tmp = head.prev;
            Node<T> node = new Node<T>(data, head, tmp);
            head.prev = node;
            tmp.next = node;
            head = node;
        }
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String print() {
        String info = "";
        if (!isEmpty()) {
            Node<T> tmp = head;
            for (; tmp.next != head; tmp = tmp.next) {
                info += tmp.data + " ";
            }
            info += tmp.data;
        }
        return info;
    }

    protected String reversePrint() {
        String info = "";
        if (!isEmpty()) {
            Node<T> tmp = head.prev;
            for (; tmp.prev != head.prev; tmp = tmp.prev) {
                info += tmp.data + " ";
            }
            info += tmp.data;
        }
        return info;
    }


    protected int size() {
        return size;
    }

    protected void insert(int index, T data) throws CircularLinkedListOutOfBounds {
        if (!isEmpty()) {

            if (index < 0) {
                throw new CircularLinkedListOutOfBounds("CircularLinkedListOutOfBounds queried index(" + index + ") < min index(0)");
            } else if (index > (size - 1)) {
                throw new CircularLinkedListOutOfBounds("CircularLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size - 1) + ")");
            }

            if (index == 0) {
                addToHead(data);
            } else {
                Node<T> tmp = head.prev;
                if (index != (size - 1)) {
                    tmp = getNode(index);
                }
                Node<T> prev = tmp.prev;
                Node<T> node = new Node<T>(data, tmp, prev);
                tmp.prev = node;
                prev.next = node;
                size++;
            }
        } else if (index == 0) {
            addToTail(data);
        } else {
            throw new CircularLinkedListOutOfBounds("CircularLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size) + ")");
        }
    }

    public T get(int index) throws CircularLinkedListOutOfBounds {

        if (index < 0) {
            throw new CircularLinkedListOutOfBounds("CircularLinkedListOutOfBounds queried index(" + index + ") < min index(0)");
        } else if (index > (size - 1)) {
            throw new CircularLinkedListOutOfBounds("CircularLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size - 1) + ")");
        }
        return getNode(index).data;
    }

    private Node<T> getNode(int index) {
        Node<T> tmp = head;
        for (int i = 0; tmp.next != head && i != index; tmp = tmp.next) {
            i++;
        }
        return tmp;
    }

    public T getHead() {
        return head.data;
    }

    public T getTail() {
        return head.prev.data;
    }

    protected void delete(T data) {
        if (!isEmpty()) {

            Node<T> tmp = head;
            for (; tmp.next != head && !tmp.data.equals(data); ) {
                tmp = tmp.next;
            }

            if(head == head.prev && head == head.next && data.equals(head.data)){
                head = null;
                size--;
            }else if(data.equals(tmp.data)){
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;

                if(head == tmp){
                    head = tmp.next;
                }
                size--;
            }

        }
    }

    public T deleteFromHead() {
        return delete(0);
    }

    public T deleteFromTail() {
        return delete(size - 1);
    }

    private T delete(int index) {
        T data= null;
        try {
            if(!isEmpty()){
                data = get(index);
                delete(data);
            }
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }
        return data;
    }
}
