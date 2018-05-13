package co.za.obothlale.kganane.linkedlist.sparse.table.dimensions.two.headers.arrays.singular;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-10-01.
 *
 */
public class TestSparse2D {

    private Sparse2D<Integer> sparse2D;

    @Test
    public void testInsertEqualDimensions() {

        sparse2D = new Sparse2D<Integer>(2);

        sparse2D.insert(0, 0, 1);
        Assert.assertEquals("1", sparse2D.print());

        sparse2D.insert(0, 1, 2);
        Assert.assertEquals("1 2", sparse2D.print());

        sparse2D.insert(1, 0, 3);
        Assert.assertEquals("1 2 3", sparse2D.print());

        sparse2D.insert(1, 1, 4);
        Assert.assertEquals("1 2 3 4", sparse2D.print());

    }

    @Test
    public void testNoneSequentialInsertEqualDimensions() {

        sparse2D = new Sparse2D<Integer>(2);

        sparse2D.insert(1, 1, 4);
        Assert.assertEquals("4", sparse2D.print());

        sparse2D.insert(0, 1, 2);
        Assert.assertEquals("2 4", sparse2D.print());

        sparse2D.insert(1, 0, 3);
        Assert.assertEquals("2 3 4", sparse2D.print());

        sparse2D.insert(0, 0, 1);
        Assert.assertEquals("1 2 3 4", sparse2D.print());

        sparse2D = new Sparse2D<Integer>(5);

        sparse2D.insert(3, 4, 5);
        sparse2D.insert(3, 2, 3);
        sparse2D.insert(0, 2, 2);
        sparse2D.insert(0, 4, 4);
        sparse2D.insert(3, 0, 6);
        sparse2D.insert(0, 0, 1);
        Assert.assertEquals("1 2 4 6 3 5", sparse2D.print());

    }

    @Test
    public void testHugerInputEqualDimensions() {
        sparse2D = new Sparse2D<Integer>(5);
        int counter = 1;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                sparse2D.insert(row, col, counter);
                counter++;
            }
        }
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25", sparse2D.print());

    }

    @Test
    public void testInsertUnequalDimensions() {
        sparse2D = new Sparse2D<Integer>(2, 3);
        int counter = 1;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                sparse2D.insert(row, col, counter);
                counter++;
            }
        }
        Assert.assertEquals("1 2 3 4 5 6", sparse2D.print());
    }

    @Test
    public void testNoneSequentialInsertUnequalDimensions() {
        sparse2D = new Sparse2D<Integer>(2, 3);

        sparse2D.insert(1, 1, 4);
        Assert.assertEquals("4", sparse2D.print());

        sparse2D.insert(0, 1, 2);
        Assert.assertEquals("2 4", sparse2D.print());

        sparse2D.insert(1, 0, 3);
        Assert.assertEquals("2 3 4", sparse2D.print());

        sparse2D.insert(0, 0, 1);
        Assert.assertEquals("1 2 3 4", sparse2D.print());


        sparse2D.insert(1, 2, 5);
        Assert.assertEquals("1 2 3 4 5", sparse2D.print());

        sparse2D.insert(1, 2, 6);
        Assert.assertEquals("1 2 3 4 6", sparse2D.print());
    }

    @Test
    public void testDeleteAtCoordinates() {

        sparse2D = new Sparse2D<Integer>(5);
        int counter = 1;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                sparse2D.insert(row, col, counter);
                counter++;
            }
        }

        Assert.assertEquals(new Integer(1), sparse2D.delete(0, 0));
        Assert.assertEquals("2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25", sparse2D.print());

        Assert.assertEquals(new Integer(25), sparse2D.delete(4, 4));
        Assert.assertEquals("2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24", sparse2D.print());

        Assert.assertEquals(new Integer(13), sparse2D.delete(2, 2));
        Assert.assertEquals("2 3 4 5 6 7 8 9 10 11 12 14 15 16 17 18 19 20 21 22 23 24", sparse2D.print());

        sparse2D.insert(0, 0, 1);
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 14 15 16 17 18 19 20 21 22 23 24", sparse2D.print());

        Assert.assertEquals(new Integer(12), sparse2D.delete(2, 1));
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10 11 14 15 16 17 18 19 20 21 22 23 24", sparse2D.print());

        Assert.assertEquals(new Integer(14), sparse2D.delete(2, 3));
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10 11 15 16 17 18 19 20 21 22 23 24", sparse2D.print());

        Assert.assertEquals(new Integer(15), sparse2D.delete(2, 4));
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10 11 16 17 18 19 20 21 22 23 24", sparse2D.print());

        Assert.assertEquals(new Integer(16), sparse2D.delete(3, 0));
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10 11 17 18 19 20 21 22 23 24", sparse2D.print());

        Assert.assertEquals(new Integer(17), sparse2D.delete(3, 1));
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10 11 18 19 20 21 22 23 24", sparse2D.print());

    }


    @Test
    public void testGet() {
        sparse2D = new Sparse2D<Integer>(2);
        Integer counter = 1;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                sparse2D.insert(row, col, counter);
                counter++;
            }
        }

        Assert.assertEquals(new Integer(1), sparse2D.get(0, 0));
        Assert.assertEquals(new Integer(2), sparse2D.get(0, 1));
        Assert.assertEquals(new Integer(3), sparse2D.get(1, 0));
        Assert.assertEquals(new Integer(4), sparse2D.get(1, 1));

    }
}
