package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    SmartDoorLock lock;
    private final int PIN = 1234;
    @BeforeEach
    public void init(){
        lock = new SmartDoorLockImpl(PIN);
    }
    @Test
    public void lockShouldBeInitiallyLocked(){
        assertTrue(lock.isLocked());
    }
    @Test
    public void lockShouldUnlockWithRightPin(){
        lock.unlock(PIN);
        assertFalse(lock.isLocked());
    }
}