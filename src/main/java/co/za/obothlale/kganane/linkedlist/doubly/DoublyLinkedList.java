package co.za.obothlale.kganane.linkedlist.doubly;


import co.za.obothlale.kganane.exceptions.DoublyLinkedListOutOfBounds;

/**
 * Created by Obothlale on 2015-05-03.
 *
 */
public class DoublyLinkedList<T extends Comparable<? super T>> {

    private Node<T> head;
    private Node<T> tail;
    private Integer size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addToHead(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addToTail(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public String printStartFromHead() {
        String info = "";
        for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
            info += tmp.data;
            if (tmp != tail) info += " ";
        }
        return info;
    }

    public String printStartFromTail() {
        String info = "";
        for (Node<T> tmp = tail; tmp != null; tmp = tmp.prev) {
            info += tmp.data;
            if (tmp != head) info += " ";
        }
        return info;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public T deleteFromHead() {
        T data = null;
        if (!isEmpty()) {
            data = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }
        return data;
    }

    public T deleteFromTail() {
        T data = null;
        if (!isEmpty()) {
            data = tail.data;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }
        return data;
    }

    public void delete(T data) {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
                size--;
            } else if (data.equals(head.data)) {
                head = head.next;
                head.prev = null;
                size--;
            } else if (data.equals(tail.data)) {
                tail = tail.prev;
                tail.next = null;
                size--;
            } else {
                Node<T> tmp = head;
                for (; tmp != tail && !data.equals(tmp.data); ) {
                    tmp = tmp.next;
                }
                if (tmp != tail) {
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                    size--;
                }
            }
        }
    }

    public T get(int index) throws DoublyLinkedListOutOfBounds {
        if (index < 0) {
            throw new DoublyLinkedListOutOfBounds("DoublyLinkedListOutOfBounds queried index(" + index + ") < min index(0)");
        } else if (index > (size - 1)) {
            throw new DoublyLinkedListOutOfBounds("DoublyLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size - 1) + ")");
        }
        return getNode(index).data;
    }

    public T getHead(){
        return head.data;
    }

    public T getTail(){
        return tail.data;
    }

    public Node<T> getNode(int index) {
        Node<T> tmp = head;
        for (int i = 0; tmp != null && i != index; tmp = tmp.next) {
            i++;
        }
        return tmp;
    }

    public void insert(int index, T data) throws DoublyLinkedListOutOfBounds {

        if (!isEmpty()) {

            if (index < 0) {
                throw new DoublyLinkedListOutOfBounds("DoublyLinkedListOutOfBounds queried index(" + index + ") < min index (0)");
            } else if (index > (size - 1)) {
                throw new DoublyLinkedListOutOfBounds("DoublyLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size - 1) + ")");
            }

            if (index == 0) {
                addToHead(data);
            } else if (index >= size) {
                addToTail(data);
            } else {
                Node<T> newNode = new Node<T>(data);
                Node<T> tmp = getNode(index);
                tmp.prev.next = newNode;
                newNode.next = tmp;
                newNode.prev = tmp.prev;
                tmp.prev = newNode;
                size++;
            }

        } else {
            if (index == 0) {
                addToHead(data);
            } else {
                throw new DoublyLinkedListOutOfBounds("DoublyLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size) + ")");
            }
        }
    }

}
