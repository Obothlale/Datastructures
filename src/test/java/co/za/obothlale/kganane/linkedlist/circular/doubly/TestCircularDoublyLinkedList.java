package co.za.obothlale.kganane.linkedlist.circular.doubly;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-05-08.
 *
 */
public class TestCircularDoublyLinkedList {


    private CircularDoublyLinkedList<Integer> circularLinkedList;

    @Test
    public void testInsertTail() {
        circularLinkedList = new CircularDoublyLinkedList<Integer>();
        for (int i = 0; i < 6; i++) {
            circularLinkedList.addToTail(i);
        }
        Assert.assertEquals("0 1 2 3 4 5", circularLinkedList.print());
        Assert.assertEquals("5 4 3 2 1 0", circularLinkedList.reversePrint());
    }

    @Test
    public void testInsertHead() {
        circularLinkedList = new CircularDoublyLinkedList<Integer>();
        for (int i = 0; i < 6; i++) {
            circularLinkedList.addToHead(i);
        }
        Assert.assertEquals("5 4 3 2 1 0", circularLinkedList.print());
        Assert.assertEquals("0 1 2 3 4 5", circularLinkedList.reversePrint());

    }

    @Test
    public void testInsertIntoIndex() {

        circularLinkedList = new CircularDoublyLinkedList<Integer>();

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

        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }

        for (int i = 0; i <= 5; i++) {
            circularLinkedList.addToTail(i);
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
    public void testGet() {
        circularLinkedList = new CircularDoublyLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            circularLinkedList.addToTail(i);
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
    public void testDelete() {
        circularLinkedList = new CircularDoublyLinkedList<Integer>();
        int testValues[] = {0, 1, 2, 3, 4, 5};

        for (int i = 0; i < 6; i++) {
            circularLinkedList.insert(i);
        }

        for (int index = 0; index < circularLinkedList.size(); index++) {
            String expectedInput = "";
            for (int subscript = 0; subscript < (testValues.length - index); subscript++) {
                expectedInput += testValues[subscript];
                if (subscript != (testValues.length - (index + 1))) {
                    expectedInput += " ";
                }
            }
            Assert.assertEquals(expectedInput, circularLinkedList.print());
            circularLinkedList.delete(testValues[testValues.length - (index + 1)]);
        }
    }

    @Test
    public void testDelete2() {
        circularLinkedList = new CircularDoublyLinkedList<Integer>();

        for (int i = 0; i < 6; i++) {
            circularLinkedList.insert(i);
        }


        circularLinkedList.delete(5);
        Assert.assertEquals("0 1 2 3 4", circularLinkedList.print());

        circularLinkedList.delete(4);
        Assert.assertEquals("0 1 2 3", circularLinkedList.print());

        circularLinkedList.delete(3);
        Assert.assertEquals("0 1 2", circularLinkedList.print());

        circularLinkedList.delete(2);
        Assert.assertEquals("0 1", circularLinkedList.print());

        circularLinkedList.delete(1);
        Assert.assertEquals("0", circularLinkedList.print());

        circularLinkedList.delete(0);
        Assert.assertEquals("", circularLinkedList.print());

        for (int i = 0; i < 6; i++) {
            circularLinkedList.insert(i);
        }

        circularLinkedList.delete(0);
        Assert.assertEquals("1 2 3 4 5", circularLinkedList.print());
        circularLinkedList.delete(1);
        Assert.assertEquals("2 3 4 5", circularLinkedList.print());
        circularLinkedList.delete(2);
        Assert.assertEquals("3 4 5", circularLinkedList.print());
        circularLinkedList.delete(3);
        Assert.assertEquals("4 5", circularLinkedList.print());
        circularLinkedList.delete(4);
        Assert.assertEquals("5", circularLinkedList.print());
        circularLinkedList.delete(5);
        Assert.assertEquals("", circularLinkedList.print());
    }

    @Test
    public void testPrintSentence() {
        CircularDoublyLinkedList<String> circularLinkedList = new CircularDoublyLinkedList<String>();
        circularLinkedList.insert("Hello");
        circularLinkedList.insert("there!");
        Assert.assertEquals("Hello there!", circularLinkedList.print());
    }
}
