package co.za.obothlale.kganane.linkedlist.sparse_table.second_dimensional;

/**
 * Created by Obothlale on 2015-07-14.
 */
public class Node<T extends Comparable<? super T>> {

    protected T data;
    protected Node<T> nextX;
    protected Node<T> nextY;
    protected int x;
    protected int y;

    public Node(){
        this(null,null,null);
    }

    public Node(T data) {
        this(data, null, null);
    }

    public Node(Node<T> nextX, Node<T> nextY) {
        this(null,nextX,nextY);
    }

    public Node(T data, Node<T> nextX, Node<T> nextY) {
        this.data = data;
        this.nextX = nextX;
        this.nextY = nextY;
    }

    public void setCoordinates(int x,int y){
        this.x = x;
        this.y = y;
    }
}
