package co.za.obothlale.kganane.linkedlist.sparse.table.dimensions.two.headers.arrays.singular;

/**
 * Created by Obothlale on 2015-09-24.
 *
 */
public class Sparse2D<T extends Comparable<? super T>> {

    private Node<T>[] arrayRow;
    private Node<T>[] arrayCol;

    public Sparse2D(int size) {

        this(size, size);
    }

    @SuppressWarnings("unchecked")
    public Sparse2D(int rowSize, int colSize) {

        arrayRow = new Node[rowSize];
        arrayCol = new Node[colSize];

        for (int index = 0; index < rowSize; index++) {
            arrayRow[index] = null;
        }
        for (int index = 0; index < colSize; index++) {
            arrayCol[index] = null;
        }
    }

    public void insert(int rowIndex, int colIndex, T data) {

        if (rowIndex < arrayRow.length && colIndex < arrayCol.length) {

            Node<T> node = new Node<T>(data);

            node.setCoordinates(rowIndex, colIndex);

            if (arrayRow[rowIndex] == null) {

                arrayRow[rowIndex] = node;

            } else {
                Node<T> rowTmp = arrayRow[rowIndex];
                Node<T> rowPrev = arrayRow[rowIndex];

                for (; rowTmp != null; rowPrev = rowTmp, rowTmp = rowTmp.nextX) {
                    if (colIndex < rowTmp.y) {
                        break;
                    } else if (rowTmp.x == rowIndex && rowTmp.y == colIndex) { // if cell occupied replace with that value just entered
                        rowTmp.data = data;
                        return;
                    }
                }

                if (rowTmp == null) { // if insert at the tail of the row

                    rowPrev.nextX = node;

                } else if (rowPrev == arrayRow[rowIndex]) { //if insert at head of row

                    node.nextX = rowPrev;

                    arrayRow[rowIndex] = node;
                } else {
                    node.nextX = rowTmp;

                    rowPrev.nextX = node;
                }
            }

            if (arrayCol[colIndex] == null) {

                arrayCol[colIndex] = node;

            } else {
                Node<T> colTmp = arrayCol[colIndex];
                Node<T> colPrev = arrayCol[colIndex];

                for (; colTmp != null; colPrev = colTmp, colTmp = colTmp.nextY) {
                    if (rowIndex < colTmp.x) {
                        break;
                    }
                }
                if (colTmp == null) { // if insert at the tail of the col

                    colPrev.nextY = node;
                } else if (colPrev == arrayCol[colIndex]) {  //if insert at head of col

                    node.nextY = colPrev;

                    arrayCol[colIndex] = node;
                } else {
                    node.nextY = colTmp;

                    colPrev.nextY = node;
                }
            }
        }
    }

    public T delete(int rowIndex, int colIndex) {

        T data = null;

        if (arrayRow[rowIndex] != null && arrayCol[colIndex] != null) {

            Node<T> rowTmp = arrayRow[rowIndex];
            Node<T> rowPrev = null;

            for (; rowTmp != null && rowTmp.y != colIndex; ) {
                rowPrev = rowTmp;
                rowTmp = rowTmp.nextX;
            }

            if (rowTmp != null) {
                Node<T> colTmp = arrayCol[colIndex];
                Node<T> colPrev = null;

                for (; colTmp != null && colTmp.x != rowIndex; ) {
                    colPrev = colTmp;
                    colTmp = colTmp.nextY;
                }

                if (colTmp != null && colTmp.data.equals(rowTmp.data)) {
                    data = rowTmp.data;

                    if (rowPrev == null) { //then rowTmp is a head node. Make its next a new head
                        arrayRow[rowIndex] = rowTmp.nextX;
                    } else {
                        rowPrev.nextX = rowTmp.nextX;
                    }

                    if (colPrev == null) { // then colTmp is a head node. Make its next new head
                        arrayCol[colIndex] = colTmp.nextY;
                    } else {
                        colPrev.nextY = colTmp.nextY;
                    }
                }
            }

        }

        return data;
    }

    public T get(int rowIndex, int colIndex) {

        T data = null;

        if (arrayRow.length <= arrayCol.length) {
            if (arrayCol[colIndex] != null) {
                Node<T> tmpCols = arrayCol[colIndex];

                boolean nodeFound = tmpCols.x == rowIndex && tmpCols.y == colIndex;
                while (!nodeFound) {
                    tmpCols = tmpCols.nextY;
                    nodeFound = tmpCols.x == rowIndex && tmpCols.y == colIndex;
                }

                data = tmpCols.data;
            }
        } else {

            if (arrayRow[rowIndex] != null) {
                Node<T> tmpRows = arrayRow[rowIndex];

                boolean flag = tmpRows.x == rowIndex && tmpRows.y == colIndex;
                while (!flag) {
                    tmpRows = tmpRows.nextY;
                    flag = tmpRows.x == rowIndex && tmpRows.y == colIndex;
                }

                data = tmpRows.data;
            }

        }
        return data;
    }

    public String print() {
        String result = "";
        for (Node<T> rowNode : arrayRow) {
            for (Node<T> colNode = rowNode; colNode != null; colNode = colNode.nextX) {
                result += colNode.data + " ";
            }
        }
        return result.trim();
    }
}
