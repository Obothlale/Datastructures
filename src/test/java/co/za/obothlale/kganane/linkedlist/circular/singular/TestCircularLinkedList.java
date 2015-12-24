package co.za.obothlale.kganane.linkedlist.circular.singular;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-05-07.
 *
 */
public class TestCircularLinkedList {

    private CircularLinkedList<Integer> circularLinkedList;

    @Test
    public void testInsert() {
        circularLinkedList = new CircularLinkedList<Integer>();
        for (int i = 0; i < 6; i++) {
            circularLinkedList.insert(i);
        }
        Assert.assertEquals("0 1 2 3 4 5", circularLinkedList.print());
    }

    @Test
    public void testDelete() {
        circularLinkedList = new CircularLinkedList<Integer>();


        for (int i = 0; i < 6; i++) {
            circularLinkedList.insert(i);
        }
        circularLinkedList.delete(5);
        Assert.assertEquals("0 1 2 3 4",circularLinkedList.print());
        circularLinkedList.delete(4);
        Assert.assertEquals("0 1 2 3",circularLinkedList.print());
        circularLinkedList.delete(3);
        Assert.assertEquals("0 1 2",circularLinkedList.print());
        circularLinkedList.delete(2);
        Assert.assertEquals("0 1",circularLinkedList.print());
        circularLinkedList.delete(1);
        Assert.assertEquals("0",circularLinkedList.print());
        circularLinkedList.delete(0);
        Assert.assertEquals("",circularLinkedList.print());
        circularLinkedList.delete(0);
        Assert.assertEquals("",circularLinkedList.print());
        circularLinkedList = new CircularLinkedList<Integer>();
        for (int i = 0; i < 6; i++) {
            circularLinkedList.insert(i);
        }
        circularLinkedList.delete(0);
        Assert.assertEquals("1 2 3 4 5",circularLinkedList.print());
        circularLinkedList.delete(1);
        Assert.assertEquals("2 3 4 5",circularLinkedList.print());
        circularLinkedList.delete(2);
        Assert.assertEquals("3 4 5",circularLinkedList.print());
        circularLinkedList.delete(3);
        Assert.assertEquals("4 5",circularLinkedList.print());
        circularLinkedList.delete(4);
        Assert.assertEquals("5",circularLinkedList.print());
        circularLinkedList.delete(5);
        Assert.assertEquals("",circularLinkedList.print());
        circularLinkedList.delete(0);
        Assert.assertEquals("",circularLinkedList.print());
    }



    @Test
    public void testGet() {
        circularLinkedList = new CircularLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            circularLinkedList.insert(i);
        }
        try {
            for (Integer i = 0; i <= 6; i++) {
                Assert.assertEquals(i, circularLinkedList.get(i));
            }
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            Assert.assertEquals("CircularLinkedListOutOfBounds queried index(6) > current max index(5)", circularLinkedListOutOfBounds.getMessage());
        }

        try {
            circularLinkedList.get(-1);
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            Assert.assertEquals("CircularLinkedListOutOfBounds queried index(-1) < min index(0)", circularLinkedListOutOfBounds.getMessage());
        }
    }

    @Test
    public void testInsertIntoIndex() {

        circularLinkedList = new CircularLinkedList<Integer>();

        try {
            circularLinkedList.insert(12, -1);
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            Assert.assertEquals("CircularLinkedListOutOfBounds queried index(12) > current max index(0)", circularLinkedListOutOfBounds.getMessage());
        }
        try {
            circularLinkedList.insert(-12, -1);
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            Assert.assertEquals("CircularLinkedListOutOfBounds queried index(-12) > current max index(0)", circularLinkedListOutOfBounds.getMessage());
        }


        try {
            circularLinkedList.insert(0, -1);
            Assert.assertEquals("-1", circularLinkedList.print());
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }

        for (int i = 0; i <= 5; i++) {
            circularLinkedList.insert(i);
        }

        try {
            circularLinkedList.insert(0, 6);
            Assert.assertEquals("6 -1 0 1 2 3 4 5", circularLinkedList.print());
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }

        try {
            circularLinkedList.insert(6, 7);
            Assert.assertEquals("6 -1 0 1 2 3 7 4 5", circularLinkedList.print());
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }

        try {
            circularLinkedList.insert(3, 8);
            Assert.assertEquals("6 -1 0 8 1 2 3 7 4 5", circularLinkedList.print());
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }
        try {
            circularLinkedList.insert(0, 10);
            Assert.assertEquals("10 6 -1 0 8 1 2 3 7 4 5", circularLinkedList.print());
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }
    }

    @Test
    public void testPrintSentence() {
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<String>();
        circularLinkedList.insert("Hello");
        circularLinkedList.insert("there!");
        Assert.assertEquals("Hello there!", circularLinkedList.print());
    }
}
