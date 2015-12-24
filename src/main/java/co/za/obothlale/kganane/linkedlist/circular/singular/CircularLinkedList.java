package co.za.obothlale.kganane.linkedlist.circular.singular;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;

/**
 * Created by Obothlale on 2015-05-06.
 *
 */
public class CircularLinkedList<T extends Comparable<? super T>> {

    private Node<T> head;
    private int size;

    public CircularLinkedList() {

        this.head = null;
        size = 0;
    }


    public void insert(T data) {

        if (isEmpty()) {

            head = new Node<T>(data);
            head.next = head;

        } else {

            Node<T> tmp = head;
            for (; tmp.next != head; ) {
                tmp = tmp.next;
            }
            tmp.next = new Node<T>(data, head);

        }

        size++;
    }

    public void insert(int index, T data) throws CircularLinkedListOutOfBounds {

        if (!isEmpty()) {

            if (index < 0) {

                throw new CircularLinkedListOutOfBounds("CircularLinkedListOutOfBounds queried index(" + index + ") < min index(0)");
            } else if (index > (size - 1)) {

                throw new CircularLinkedListOutOfBounds("CircularLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size - 1) + ")");
            }

            Node<T> tmp = getNode(index);

            Node<T> prev = head;
            for (; prev.next != tmp; ) {
                prev = prev.next;
            }

            if (index == 0) {

                Node<T> node = new Node<T>(data, head);
                if (prev == tmp) {
                    head.next = node;
                } else {
                    prev.next = node;
                }
                head = node;

            } else {
                prev.next = new Node<T>(data, tmp);
            }

        } else if (index == 0) {
            head = new Node<T>(data);
            head.next = head;
        } else {
            throw new CircularLinkedListOutOfBounds("CircularLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size) + ")");
        }
        size++;
    }

    public void delete(T data) {

        if (!isEmpty()) {
            if (head == head.next && data.equals(head.data)) {
                head = null;
                size--;
            }else if(data.equals(head.data)){
                Node<T> tmp = head;
                for (; tmp.next != head ; ) {
                    tmp = tmp.next;
                }
                tmp.next = head.next;
                head = head.next;
                size--;
            }else {
                Node<T> tmp = head;
                Node<T> prev = tmp;

                for (; tmp.next != head && !data.equals(tmp.data); ) {
                    prev = tmp;
                    tmp = tmp.next;
                }

                if (data.equals(tmp.data)) {
                    prev.next = tmp.next;
                    tmp.next = null;
                    tmp.data = null;
                    size--;
                }

            }
        }
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

    public void addToTail(T data) {
        insert(data);
    }

    public void addToHead(T data) {
        try {
            insert(0, data);
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }
    }

    public T deleteFromTail() {
        T data = null;
        try {
            if (!isEmpty()) {
                data = get(size - 1);
                delete(data);
            }
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }
        return data;
    }

    public T getHead() {
        return head.data;
    }

    public T getTail() {
        T data = null;
        try {
            data = get(size - 1);
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }
        return data;
    }

    public T deleteFromHead() {
        T data = null;
        try {
            if (!isEmpty()) {
                data = get(0);
                delete(data);
            }
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }
        return data;
    }
}
