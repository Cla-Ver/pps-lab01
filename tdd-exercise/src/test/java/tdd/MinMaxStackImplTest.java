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
    @Test
    public void stackShouldThrowExceptionOnGetValueIfStackIsEmpty(){
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }
    @Test
    public void stackShouldRemovePoppedValues(){
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    @Test
    public void stackShouldReturnPoppedValues(){
        stack.push(1);
        assertEquals(1, stack.pop());
    }
    @Test
    public void stackShouldNotRemovePeekedValue(){
        stack.push(1);
        stack.peek();
        assertFalse(stack.isEmpty());
    }
    @Test
    public void stackShouldReturnPeekedValue(){
        stack.push(1);
        assertEquals(1, stack.peek());
    }
    @Test
    public void peekShouldThrowExceptionOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

}