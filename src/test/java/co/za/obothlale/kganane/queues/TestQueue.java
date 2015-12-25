package co.za.obothlale.kganane.queues;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-05-16.
 */
public class TestQueue {

    Queue<Integer> queue;

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

       // Assert.assertEquals(new Integer(4), queue.dequeue());
        Assert.assertEquals("0 1 2 3",queue.print());
    }
}
