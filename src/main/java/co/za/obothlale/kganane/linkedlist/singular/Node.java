package co.za.obothlale.kganane.linkedlist.singular;

/**
 * Created by Obothlale on 2015-05-02.
 *
 */
public class Node<T extends Comparable<? super T>> {

    protected T data;
    protected Node<T> next;

    protected Node(T data){

        this(data,null);
    }

    protected Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

}
