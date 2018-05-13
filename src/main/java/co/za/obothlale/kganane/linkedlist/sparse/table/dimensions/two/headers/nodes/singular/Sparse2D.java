package co.za.obothlale.kganane.linkedlist.sparse.table.dimensions.two.headers.nodes.singular;

/**
 * Created by Obothlale on 2015-07-14.
 *
 */
public class Sparse2D<T extends Comparable<? super T>> {

    private Node<T> rowHead;
    private Node<T> rowTail;
    private Node<T> headCol;
    private Node<T> colTail;
    private int headRowSize, headColSize;


    public Sparse2D(int size) {
        this(size, size);
    }

    public Sparse2D(int rowSize, int colSize) {

        if (rowSize > 0) {
            if (rowHead == null) {

                rowHead = rowTail = new Node<T>();

                rowHead.y = 0;

                headRowSize++;
            }
            for (int index = 1; index < rowSize; index++) {

                Node<T> node = new Node<T>();

                node.x = index;

                rowTail.nextY = node;

                node.prevY = rowTail;

                rowTail = node;

                headRowSize++;
            }

        }

        if (colSize > 0) {

            if (headCol == null) {

                headCol = colTail = new Node<T>();

                headCol.x = 0;

                headColSize++;
            }
            for (int index = 1; index < colSize; index++) {

                Node<T> node = new Node<T>();

                node.x = index;

                colTail.nextX = node;

                node.prevX = colTail;

                colTail = node;

                headColSize++;
            }

        }

    }

    public int getRowSize() {

        return headRowSize;
    }

    public int getColSize() {

        return headColSize;
    }

    public void insert(int rowIndex, int colIndex, T data) {


    }

}