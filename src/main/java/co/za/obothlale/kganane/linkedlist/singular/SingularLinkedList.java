package co.za.obothlale.kganane.linkedlist.singular;

import co.za.obothlale.kganane.exceptions.SingularLinkedListOutOfBounds;

/**
 * Created by Obothlale on 2015-05-02.
 *
 */
public class SingularLinkedList<T extends Comparable<? super T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SingularLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(T data) {
        head = new Node<T>(data, head);
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addToTail(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data);
        } else {
            tail.next = new Node<T>(data);
            tail = tail.next;
        }
        size++;
    }

    public boolean isInList(T data) {
        boolean flag = false;
        for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
            if (data.compareTo(tmp.data) == 0) {
                flag = true;
            }
        }
        return flag;
    }

    public String print() {
        String info = "";
        for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
            info += tmp.data;
            if (tmp != tail) info += " ";
        }
        return info;
    }

    public T deleteFromTail() {
        T data = null;
        if (!isEmpty()) {
            data = tail.data;
            if (head == tail) {
                head = tail = null;
            } else {
                Node<T> prev = head;
                for (; prev.next != tail;) {
                    prev = prev.next;
                }
                tail.data = null;
                tail = prev;
                tail.next = null;
            }
            size--;
        }
        return data;
    }

    public T deleteFromHead() {
        T data = null;
        if (!isEmpty()) {
            data = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                Node<T> tmp = head;
                head = head.next;
                tmp.data = null;
            }
            size--;
        }
        return data;
    }

    public void delete(T data) {
        if (!isEmpty()) {
            if (head == tail && data.equals(head.data)) {
                head = tail = null;
                size--;
            } else if (data.equals(head.data)) {
                Node<T> tmp = head;
                head = head.next;
                tmp.data = null;
                tmp.next = null;
                size--;
            } else {
                Node<T> prev = head;
                Node<T> tmp = head.next;
                while (tmp != null) {
                    if (data.equals(tmp.data)) {
                        prev.next = tmp.next;
                        if (tmp == tail) {
                            tail = prev;
                        }
                        size--;
                        break;
                    }
                    prev = tmp;
                    tmp = tmp.next;
                }
            }
        }
    }

    public T get(int index) throws SingularLinkedListOutOfBounds {
        if (index < 0) {
            throw new SingularLinkedListOutOfBounds("SingularLinkedListOutOfBounds queried index(" + index + ") < min index(0)");
        } else if (index > (size - 1)) {
            throw new SingularLinkedListOutOfBounds("SingularLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size - 1) + ")");
        }
        Node<T> node = getNode(index);
        return node.data;
    }

    public Node<T> getNode(int index) {
        if (index < size) {
            Node<T> tmp = head;
            for (int i = 0; tmp != null && i != index; tmp = tmp.next) {
                i++;
            }
            return tmp;
        }
        return null;
    }

    public void insert(int index, T data) throws SingularLinkedListOutOfBounds {

        if (!isEmpty()) {
            if (index < 0) {
                throw new SingularLinkedListOutOfBounds("SingularLinkedListOutOfBounds queried index(" + index + ") > current max index(0)");
            } else if (index > (size - 1)) {
                throw new SingularLinkedListOutOfBounds("SingularLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size - 1) + ")");
            }

            if (index == 0) {
                addToHead(data);
            } else if (index == size - 1) {
                addToTail(data);
            } else {
                Node<T> newNode = new Node<T>(data);
                Node<T> tmp = getNode(index);
                Node<T> prev = head;
                for (; prev.next != tmp; ) {
                    prev = prev.next;
                }
                newNode.next = tmp;
                prev.next = newNode;
                size++;
            }
        } else {
            if (index == 0) {
                addToHead(data);
            } else {
                throw new SingularLinkedListOutOfBounds("SingularLinkedListOutOfBounds queried index(" + index + ") > current max index(" + (size) + ")");
            }
        }
    }

    public T getHead() {
        return head.data;
    }

    public T getTail() {
        return tail.data;
    }
}
