package co.za.obothlale.kganane.linkedlist.sparse_table.second_dimensional;

/**
 * Created by Obothlale on 2015-07-14.
 */
public class Sparse2D<T extends Comparable<? super T>> {

    private Node<T> headRow, tailRow;
    private Node<T> headCol, tailCol;
    private int headRowSize, headColSize;


    public Sparse2D() {
    }

    public Sparse2D(int rowSize, int colSize) {

        initializeRow(rowSize);

        initializeCol(colSize);

    }

    public void initializeRow(int rowSize) {
        if (rowSize > 0) {
            if (headRow == null) {

                headRow = tailRow = new Node<T>();

                headRowSize++;
            }
            for (int index = 1; index < rowSize; index++) {

                tailRow.nextY = new Node<T>();

                tailRow = tailRow.nextY;

                headRowSize++;
            }

        }
    }

    public void initializeCol(int colSize) {
        if (colSize > 0) {

            if (headCol == null) {

                headCol = tailCol = new Node<T>();

                headColSize++;
            }
            for (int index = 1; index < colSize; index++) {

                tailCol.nextX = new Node<T>();

                tailCol = tailCol.nextX;

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