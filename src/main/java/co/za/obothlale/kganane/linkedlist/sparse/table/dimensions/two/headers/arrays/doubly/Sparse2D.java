package co.za.obothlale.kganane.linkedlist.sparse.table.dimensions.two.headers.arrays.doubly;

/**
 * Created by Obothlale on 2015-09-24.
 *
 */
public class Sparse2D<T extends Comparable<? super T>> {

    private Node<T>[] arrayRowHead;
    private Node<T>[] arrayRowTail;
    private Node<T>[] arrayColHead;
    private Node<T>[] arrayColTail;

    public Sparse2D(int size) {

        this(size, size);
    }

    @SuppressWarnings("unchecked")
    public Sparse2D(int rowSize, int colSize) {

        arrayRowHead = new Node[rowSize];
        arrayRowTail = new Node[rowSize];
        arrayColHead = new Node[colSize];
        arrayColTail = new Node[colSize];

        for (int index = 0; index < rowSize; index++) {
            arrayRowHead[index] = null;
            arrayRowTail[index] = null;
        }
        for (int index = 0; index < colSize; index++) {
            arrayColHead[index] = null;
            arrayColTail[index] = null;
        }
    }

    public void insert(int rowIndex, int colIndex, T data) {

        if (rowIndex < arrayRowHead.length && colIndex < arrayColHead.length) {

            Node<T> node = new Node<T>(data);

            node.setCoordinates(rowIndex, colIndex);

            if (arrayRowHead[rowIndex] == null) {

                arrayRowHead[rowIndex] = node;
                arrayRowTail[rowIndex] = node;

            } else {
                Node<T> rowTmp = arrayRowHead[rowIndex];
                Node<T> rowTail = arrayRowTail[rowIndex];


                for (; rowTmp != rowTail; rowTmp = rowTmp.nextX) {
                    if (colIndex < rowTmp.y) {
                        break;
                    }
                }
                if (rowTmp == arrayRowHead[rowIndex] && colIndex < rowTmp.y) { //if insert at head of row

                    node.nextX = rowTmp;

                    rowTmp.prevX = node;

                    arrayRowHead[rowIndex] = node;

                } else if (rowTmp == rowTail && colIndex > rowTmp.y) { // if insert at the tail of the row

                    rowTmp.nextX = node;

                    node.prevX = rowTmp;

                    arrayRowTail[rowIndex] = node; // new node will become the new tail

                } else if (rowTmp.x == rowIndex && rowTmp.y == colIndex) { // if cell occupied replace with that value just entered
                    rowTmp.data = data;
                    return;

                } else {
                    node.nextX = rowTmp;

                    node.prevX = rowTmp.prevX;

                    rowTmp.prevX.nextX = node;

                    rowTmp.prevX = node;
                }
            }

            if (arrayColHead[colIndex] == null) {

                arrayColHead[colIndex] = node;

                arrayColTail[colIndex] = node;

            } else {
                Node<T> colTmp = arrayColHead[colIndex];
                Node<T> colTail = arrayColTail[colIndex];

                for (; colTmp != colTail; colTmp = colTmp.nextY) {
                    if (rowIndex < colTmp.x) {
                        break;
                    }
                }

                if (colTmp == arrayColHead[colIndex] && rowIndex < colTmp.x) {  //if insert at head of col
                    node.nextY = colTmp;

                    colTmp.prevY = node;

                    arrayColHead[colIndex] = node;
                } else if (colTmp == colTail && rowIndex > colTmp.x) { // if insert at the tail of the col

                    colTmp.nextY = node;

                    node.prevY = colTmp;

                    arrayColTail[colIndex] = node; // new node will become the new tail


                } else {
                    node.nextY = colTmp;

                    node.prevY = colTmp.prevY;

                    colTmp.prevY.nextY = node;

                    colTmp.prevY = node;
                }
            }
        }
    }

    public T delete(int rowIndex, int colIndex) {

        T data = null;

        if (arrayRowHead[rowIndex] != null && arrayColHead[colIndex] != null) {

            Node<T> tmpNode = arrayRowHead[rowIndex];

            for (; tmpNode != null && tmpNode.y != colIndex; ) {

                tmpNode = tmpNode.nextX;
            }

            if (tmpNode != null) {

                data = tmpNode.data;

                if (tmpNode == arrayRowHead[rowIndex]) { //then rowTmp is a head node. Make its next a new head
                    arrayRowHead[rowIndex] = tmpNode.nextX;
                    arrayRowHead[rowIndex].prevX = null;
                } else if (tmpNode == arrayRowTail[rowIndex]) {
                    arrayRowTail[rowIndex] = tmpNode.prevX;
                    arrayRowTail[rowIndex].nextX = null;
                    tmpNode.prevX = null;
                } else {
                    tmpNode.prevX.nextX = tmpNode.nextX;
                    tmpNode.nextX.prevX = tmpNode.prevX;
                    tmpNode.nextX = null;
                    tmpNode.prevX = null;
                }


                if (tmpNode == arrayColHead[colIndex]) { //then rowTmp is a head node. Make its next a new head
                    arrayColHead[colIndex] = tmpNode.nextY;
                    arrayColHead[colIndex].prevY = null;
                } else if (tmpNode == arrayColTail[colIndex]) {
                    arrayColTail[colIndex] = tmpNode.prevY;
                    arrayColTail[colIndex].nextY = null;
                    tmpNode.prevY = null;
                } else {
                    tmpNode.prevY.nextY = tmpNode.nextY;
                    tmpNode.nextY.prevY = tmpNode.prevY;
                    tmpNode.nextY = null;
                    tmpNode.prevY = null;
                }
            }
        }

        return data;
    }

    public T get(int rowIndex, int colIndex) {

        T data = null;

        if (arrayRowHead.length <= arrayColHead.length) {
            if (arrayColHead[colIndex] != null) {
                Node<T> tmpCols = arrayColHead[colIndex];

                boolean nodeFound = tmpCols.x == rowIndex && tmpCols.y == colIndex;
                while (!nodeFound) {
                    tmpCols = tmpCols.nextY;
                    nodeFound = tmpCols.x == rowIndex && tmpCols.y == colIndex;
                }

                data = tmpCols.data;
            }
        } else {

            if (arrayRowHead[rowIndex] != null) {
                Node<T> tmpRows = arrayRowHead[rowIndex];

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
        for (Node<T> rowNode : arrayRowHead) {
            for (Node<T> colNode = rowNode; colNode != null; colNode = colNode.nextX) {
                result += colNode.data + " ";
            }
        }
        return result.trim();
    }

    public String printReverse() {
        String result = "";
        for (int rowIndex = arrayRowTail.length - 1; rowIndex > -1; rowIndex--) {
            for (Node<T> colNode = arrayRowTail[rowIndex]; colNode != null; colNode = colNode.prevX) {
                result += colNode.data + " ";
            }
        }
        return result.trim();
    }
}
