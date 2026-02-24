package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    CircularQueue queue;
    final int QUEUE_SIZE = 10;
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
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }
}
