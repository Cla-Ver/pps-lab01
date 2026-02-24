package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    MinMaxStack stack;
    private final int MAX_VALUE = 10;
    private final int MIN_VALUE = 1;

    @BeforeEach
    public void init(){
        stack = new MinMaxStackImpl();
    }
    @Test
    public void stackShouldInitiallyBeEmpty(){
        assertTrue(stack.isEmpty());
    }
    @Test
    public void stackShouldNotBeEmptyOnValuePush(){
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
    private void fillStack(){
        for(int counter = MIN_VALUE; counter <= MAX_VALUE; counter++){
            stack.push(counter);
        }
    }
    @Test
    public void stackShouldReturnMinimumValue(){
        fillStack();
        assertEquals(MIN_VALUE, stack.getMin());
    }
    @Test
    public void minShouldThrowExceptionOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> stack.getMin());
    }
    @Test
    public void stackShouldReturnMaximumValue(){
        fillStack();
        assertEquals(MAX_VALUE, stack.getMax());
    }
}