package co.za.obothlale.kganane.queues.use_circularlinkedlist.singular;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class TestQueue {

    private Queue<Integer> queue;

    @Before
    public void setup() {

        queue = new Queue<Integer>();
    }

    @Test
    public void testQueue() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        Assert.assertEquals("0 1 2 3 4", queue.print());
    }

    @Test
    public void testDequeue() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        Assert.assertEquals(new Integer(4), queue.dequeue());
        Assert.assertEquals("0 1 2 3", queue.print());
        Assert.assertEquals(new Integer(3), queue.dequeue());
        Assert.assertEquals("0 1 2", queue.print());
        Assert.assertEquals(new Integer(2), queue.dequeue());
        Assert.assertEquals("0 1", queue.print());
        Assert.assertEquals(new Integer(1), queue.dequeue());
        Assert.assertEquals("0", queue.print());
        Assert.assertEquals(new Integer(0), queue.dequeue());
        Assert.assertEquals("", queue.print());
        Assert.assertNull(queue.dequeue());
    }

    @Test
    public void testPeekFrontQueue() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        Assert.assertEquals(new Integer(0),queue.peekFrontQueue());
    }

    @Test
    public void testPeekBackQueue() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        Assert.assertEquals(new Integer(4),queue.peekBackQueue());
    }

    @Test
    public void testPeekAtIndex() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        try {
            Assert.assertEquals(new Integer(2),queue.peekAtIndex(2));
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            circularLinkedListOutOfBounds.printStackTrace();
        }
        try {
            Assert.assertEquals(new Integer(2),queue.peekAtIndex(5));
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            Assert.assertEquals("CircularLinkedListOutOfBounds queried index(5) > current max index(4)", circularLinkedListOutOfBounds.getMessage());
        }
        try {
            Assert.assertEquals(new Integer(2),queue.peekAtIndex(-1));
        } catch (CircularLinkedListOutOfBounds circularLinkedListOutOfBounds) {
            Assert.assertEquals("CircularLinkedListOutOfBounds queried index(-1) < min index(0)",circularLinkedListOutOfBounds.getMessage());
        }
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(queue.isEmpty());
    }
}
