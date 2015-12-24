package co.za.obothlale.kganane.linkedlist.doubly;

import co.za.obothlale.kganane.exceptions.DoublyLinkedListOutOfBounds;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-05-03.
 *
 */
public class TestDoublyLinkedList {

    private DoublyLinkedList<Integer> doublyLinkedList;

    @Before
    public void setup() {
    }

    @Test
    public void testAddToHead() {
        doublyLinkedList = new DoublyLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            doublyLinkedList.addToHead(i);
        }
        Assert.assertEquals("5 4 3 2 1 0", doublyLinkedList.printStartFromHead());
        Assert.assertEquals("0 1 2 3 4 5", doublyLinkedList.printStartFromTail());
    }

    @Test
    public void testAddToTail() {
        doublyLinkedList = new DoublyLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            doublyLinkedList.addToTail(i);
        }
        Assert.assertEquals("0 1 2 3 4 5", doublyLinkedList.printStartFromHead());
        Assert.assertEquals("5 4 3 2 1 0", doublyLinkedList.printStartFromTail());
    }

    @Test
    public void testDeleteFromHead() {
        doublyLinkedList = new DoublyLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            doublyLinkedList.addToHead(i);
        }
        doublyLinkedList.deleteFromHead();
        Assert.assertEquals("4 3 2 1 0", doublyLinkedList.printStartFromHead());
        Assert.assertEquals("0 1 2 3 4", doublyLinkedList.printStartFromTail());
    }

    @Test
    public void testDeleteFromTail() {
        doublyLinkedList = new DoublyLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            doublyLinkedList.addToTail(i);
        }
        doublyLinkedList.deleteFromTail();
        Assert.assertEquals("0 1 2 3 4", doublyLinkedList.printStartFromHead());
        Assert.assertEquals("4 3 2 1 0", doublyLinkedList.printStartFromTail());
    }

    @Test
    public void testSearchAndDelete() {
        doublyLinkedList = new DoublyLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            doublyLinkedList.addToTail(i);
        }
        doublyLinkedList.delete(2);
        org.junit.Assert.assertEquals("0 1 3 4 5", doublyLinkedList.printStartFromHead());
        doublyLinkedList.delete(0);
        doublyLinkedList.delete(4);
        org.junit.Assert.assertEquals("1 3 5", doublyLinkedList.printStartFromHead());
        doublyLinkedList.delete(5);
        org.junit.Assert.assertEquals("1 3", doublyLinkedList.printStartFromHead());
        doublyLinkedList.delete(3);
        org.junit.Assert.assertEquals("1", doublyLinkedList.printStartFromHead());
        doublyLinkedList.delete(1);
        org.junit.Assert.assertEquals("", doublyLinkedList.printStartFromHead());
        doublyLinkedList.delete(1);
        org.junit.Assert.assertEquals("", doublyLinkedList.printStartFromHead());

    }

    @Test
    public void testInsert(){
        doublyLinkedList = new DoublyLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            doublyLinkedList.addToTail(i);
        }
        int index = 4;
        try {
            doublyLinkedList.insert(index,6);
            Assert.assertEquals("0 1 2 3 6 4 5",doublyLinkedList.printStartFromHead());
            Assert.assertEquals("5 4 6 3 2 1 0",doublyLinkedList.printStartFromTail());

            index = 0;
            doublyLinkedList.insert(index,7);

            index = 6;
            doublyLinkedList.insert(index,9);
            Assert.assertEquals("7 0 1 2 3 6 9 4 5",doublyLinkedList.printStartFromHead());
            Assert.assertEquals("5 4 9 6 3 2 1 0 7",doublyLinkedList.printStartFromTail());

            index = 8;
            doublyLinkedList.insert(index,8);

        } catch (DoublyLinkedListOutOfBounds doublyLinkedListOutOfBounds) {
            Assert.assertEquals("DoublyLinkedListOutOfBounds queried index(8) > current max index(7)",doublyLinkedListOutOfBounds.getMessage());
        }

        try {
            index = -1;
            doublyLinkedList.insert(index,8);
        } catch (DoublyLinkedListOutOfBounds doublyLinkedListOutOfBounds) {
            Assert.assertEquals("DoublyLinkedListOutOfBounds queried index(-1) < min index (0)", doublyLinkedListOutOfBounds.getMessage());
        }
    }

    @Test
    public void testGet() {
        doublyLinkedList = new DoublyLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            doublyLinkedList.addToTail(i);
        }
        try {
            for (Integer i = 0; i <= 6; i++) {
                Assert.assertEquals(i, doublyLinkedList.get(i));
            }

        } catch (DoublyLinkedListOutOfBounds doublyLinkedListOutOfBounds) {
            Assert.assertEquals("DoublyLinkedListOutOfBounds queried index(6) > current max index(5)",doublyLinkedListOutOfBounds.getMessage());
        }
        try {
            doublyLinkedList.get(-1);
        } catch (DoublyLinkedListOutOfBounds doublyLinkedListOutOfBounds) {
            Assert.assertEquals("DoublyLinkedListOutOfBounds queried index(-1) < min index(0)",doublyLinkedListOutOfBounds.getMessage());
        }
    }
}
