package co.za.obothlale.kganane.linkedlist.circular.doubly;

/**
 * Created by Obothlale on 2015-05-06.
 *
 */
public class Node<T extends Comparable<? super T>> {

    protected T data;
    protected Node<T> next;
    protected Node<T> prev;
    private String testingGit;

    public Node(T data){
        this(data,null,null);
    }

    public Node(T data, Node<T> next,Node<T>prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
