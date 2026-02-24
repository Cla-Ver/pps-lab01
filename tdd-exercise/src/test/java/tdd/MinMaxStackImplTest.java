package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    MinMaxStack stack;
    @BeforeEach
    public void init(){
        stack = new MinMaxStackImpl();
    }
    @Test
    public void stackShouldInitiallyBeEmpty(){
        assertTrue(stack.isEmpty());
    }
    @Test
    public void stackShouldNotBeEmptyOnElementPush(){
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
    @Test
    public void stackShouldGrowWhenAddingValue(){
        stack.push(1);
        assertEquals(1, stack.size());
    }
}