package co.za.obothlale.kganane.linkedlist.circular.singular;

/**
 * Created by Obothlale on 2015-05-06.
 *
 */
public class Node<T extends Comparable<? super T>> {
    protected T data;
    protected Node<T> next;

    public Node(T data){
        this(data,null);
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
