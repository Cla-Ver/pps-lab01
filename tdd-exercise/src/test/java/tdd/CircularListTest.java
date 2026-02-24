package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    CircularQueue queue;
    final int QUEUE_SIZE = 10;
    final int MIN_VALUE = 1;
    @BeforeEach
    public void init(){
        queue = new CircularQueueImpl(QUEUE_SIZE);
    }
    @Test
    public void queueShouldInitiallyBeEmpty() {
        assertTrue(queue.isEmpty());
    }
    @Test
    public void queueShouldNotAllowZeroOrNegativeMaxSize(){
        assertThrows(IllegalArgumentException.class, () -> queue = new CircularQueueImpl(-1));
    }
    @Test
    public void queueShouldAllowEnqueue(){
        queue.enqueue(MIN_VALUE);
        assertFalse(queue.isEmpty());
    }
    @Test
    public void queueShouldReturnDequeuedValue(){
        queue.enqueue(MIN_VALUE);
        assertEquals(MIN_VALUE, queue.dequeue());
    }
    @Test
    public void queueShouldShrinkOnDequeue(){
        queue.enqueue(MIN_VALUE);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
    private void fillQueue(){
        for(int counter = 0; counter < queue.getMaxSize(); counter = counter + 1){
            queue.enqueue(counter);
        }
    }
    @Test
    public void queueShouldNotIncreaseSizeIfEnqueueWhenFull(){
        fillQueue();
        queue.enqueue(MIN_VALUE);
        assertEquals(QUEUE_SIZE, queue.getMaxSize());
    }
    @Test
    public void queueShouldReplaceOldestElementIfEnqueueWhileFull(){
        fillQueue();
        queue.enqueue(queue.getMaxSize());
        for(int counter = 0; counter < queue.getMaxSize() - 1; counter++){
            queue.dequeue();
        }
        assertEquals(queue.getMaxSize(), queue.dequeue());
    }
}
