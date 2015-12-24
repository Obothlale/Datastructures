package co.za.obothlale.kganane.linkedlist.singular;

import co.za.obothlale.kganane.exceptions.SingularLinkedListOutOfBounds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-05-02.
 *
 */
public class TestSingularLinkedList {

    private SingularLinkedList<Integer> singularLinkedList;

    @Before
    public void setup() {

    }

    @Test
    public void testIsEmpty() {
        singularLinkedList = new SingularLinkedList<Integer>();
        Assert.assertTrue(singularLinkedList.isEmpty());
    }

    @Test
    public void testAddToHead() {
        singularLinkedList = new SingularLinkedList<Integer>();
        Integer data = 1;
        singularLinkedList.addToHead(data);
        Assert.assertTrue(singularLinkedList.isInList(data));
    }

    @Test
    public void testAddToTail() {
        singularLinkedList = new SingularLinkedList<Integer>();
        Integer data = 1;
        singularLinkedList.addToTail(data);
        Assert.assertTrue(singularLinkedList.isInList(data));
    }

    @Test
    public void testFromAddToHead() {
        singularLinkedList = new SingularLinkedList<Integer>();
        for (Integer i = 0; i <= 5; i++) {
            singularLinkedList.addToHead(i);
        }
        Assert.assertEquals("5 4 3 2 1 0", singularLinkedList.print());
    }

    @Test
    public void testFromAddToTail() {
        singularLinkedList = new SingularLinkedList<Integer>();
        for (Integer i = 0; i <= 5; i++) {
            singularLinkedList.addToTail(i);
        }
        Assert.assertEquals("0 1 2 3 4 5", singularLinkedList.print());
    }

    @Test
    public void testDeleteFromHead() {
        singularLinkedList = new SingularLinkedList<Integer>();
        for (Integer i = 0; i <= 5; i++) {
            singularLinkedList.addToHead(i);
        }
        singularLinkedList.deleteFromHead();
        Assert.assertEquals("4 3 2 1 0", singularLinkedList.print());
    }

    @Test
    public void testDeleteFromToTail() {
        singularLinkedList = new SingularLinkedList<Integer>();
        for (Integer i = 0; i <= 5; i++) {
            singularLinkedList.addToTail(i);
        }
        singularLinkedList.deleteFromTail();
        Assert.assertEquals("0 1 2 3 4", singularLinkedList.print());
    }

    @Test
    public void testSearchAndDelete() {
        singularLinkedList = new SingularLinkedList<Integer>();
        for (Integer i = 0; i <= 5; i++) {
            singularLinkedList.addToTail(i);
        }
        singularLinkedList.delete(2);
        Assert.assertEquals("0 1 3 4 5", singularLinkedList.print());
        singularLinkedList.delete(0);
        singularLinkedList.delete(4);
        Assert.assertEquals("1 3 5", singularLinkedList.print());
        singularLinkedList.delete(5);
        Assert.assertEquals("1 3", singularLinkedList.print());
        singularLinkedList.delete(3);
        Assert.assertEquals("1", singularLinkedList.print());
        singularLinkedList.delete(1);
        Assert.assertEquals("", singularLinkedList.print());
        singularLinkedList.delete(1);
        Assert.assertEquals("", singularLinkedList.print());

    }

    @Test
    public void testInsert() {
        try {
            singularLinkedList = new SingularLinkedList<Integer>();
            for (int i = 0; i <= 5; i++) {
                singularLinkedList.addToTail(i);
            }
            int index = 4;
            singularLinkedList.insert(index, 6);
            Assert.assertEquals("0 1 2 3 6 4 5", singularLinkedList.print());


            index = 0;
            singularLinkedList.insert(index, 7);
            Assert.assertEquals("7 0 1 2 3 6 4 5", singularLinkedList.print());
            index = 6;
            singularLinkedList.insert(index, 9);
            Assert.assertEquals("7 0 1 2 3 6 9 4 5", singularLinkedList.print());
            index = 8;
            singularLinkedList.insert(index, 8);
            Assert.assertEquals("7 0 1 2 3 6 9 4 5 8", singularLinkedList.print());

            singularLinkedList.insert(-1, 10);

        } catch (SingularLinkedListOutOfBounds singularLinkedListOutOfBounds) {
            Assert.assertEquals("SingularLinkedListOutOfBounds queried index(-1) > current max index(0)", singularLinkedListOutOfBounds.getMessage());
        }

        try {
            singularLinkedList.insert(10, 10);
        } catch (SingularLinkedListOutOfBounds singularLinkedListOutOfBounds) {
            Assert.assertEquals("SingularLinkedListOutOfBounds queried index(10) > current max index(9)", singularLinkedListOutOfBounds.getMessage());
        }

    }

    @Test
    public void testGet() {
        singularLinkedList = new SingularLinkedList<Integer>();
        for (int i = 0; i <= 5; i++) {
            singularLinkedList.addToTail(i);
        }
        try {
            for (Integer i = 0; i <= 6; i++) {
                Assert.assertEquals(i, singularLinkedList.get(i));
            }

        } catch (SingularLinkedListOutOfBounds singularLinkedListOutOfBounds) {
            Assert.assertEquals("SingularLinkedListOutOfBounds queried index(6) > current max index(5)", singularLinkedListOutOfBounds.getMessage());
        }
        try{
            singularLinkedList.get(-1);
        }catch (SingularLinkedListOutOfBounds singularLinkedListOutOfBounds) {
            Assert.assertEquals("SingularLinkedListOutOfBounds queried index(-1) < min index(0)", singularLinkedListOutOfBounds.getMessage());
        }
    }
}
