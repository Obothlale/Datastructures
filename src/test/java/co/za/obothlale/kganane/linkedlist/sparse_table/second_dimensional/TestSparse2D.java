package co.za.obothlale.kganane.linkedlist.sparse_table.second_dimensional;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-09-19.
 *
 */
public class TestSparse2D {

    private Sparse2D sparse2D;

    @Test
    public void testInitializeRow(){
        sparse2D = new Sparse2D();

        int size = 5;

        sparse2D.initializeRow(size);

        Assert.assertEquals(size,sparse2D.getRowSize());
    }

    @Test
    public void testInitializeCol(){
        sparse2D = new Sparse2D();

        int size = 5;

        sparse2D.initializeCol(size);

        Assert.assertEquals(size,sparse2D.getColSize());
    }

    @Test
    public void testSparse2DConstructor(){

        int size = 5;

        sparse2D = new Sparse2D(size,size);

        Assert.assertEquals(size,sparse2D.getRowSize());
        Assert.assertEquals(size,sparse2D.getColSize());
    }

    @Test
    public void testInsert(){
        int size = 2;

        sparse2D = new Sparse2D(size,size);

        sparse2D.insert(0,0,1);

        sparse2D.insert(0,1,2);

        sparse2D.insert(1,0,3);

        sparse2D.insert(1,1,4);
    }

}
