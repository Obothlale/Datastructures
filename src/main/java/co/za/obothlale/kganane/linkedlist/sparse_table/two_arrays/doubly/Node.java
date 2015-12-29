package co.za.obothlale.kganane.linkedlist.sparse_table.two_arrays.doubly;

/**
 * Created by Obothlale on 2015-09-24.
 *
 */
public class Node<T extends Comparable<? super T>> {

    protected T data;
    protected Node<T> nextX;
    protected Node<T> prevX;
    protected Node<T> nextY;
    protected Node<T> prevY;
    protected int x;
    protected int y;

    public Node() {

        this(null, null, null, null, null);
    }

    public Node(T data) {

        this(data, null, null, null, null);
    }

    public Node(Node<T> nextX, Node<T> prevX, Node<T> nextY, Node<T> prevY) {

        this(null, nextX, prevX, nextY, prevY);
    }

    public Node(T data, Node<T> nextX, Node<T> prevX, Node<T> nextY, Node<T> prevY) {
        this.data = data;
        this.nextX = nextX;
        this.prevX = prevX;
        this.nextY = nextY;
        this.prevY = prevY;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}