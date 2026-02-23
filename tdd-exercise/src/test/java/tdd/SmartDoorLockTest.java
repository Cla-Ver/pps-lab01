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
    @Test
    public void lockShouldUnlockWhileUnlocked(){
        lock.unlock(PIN);
        lock.unlock(PIN);
        assertFalse(lock.isLocked());
    }
    @Test
    public void lockShouldLockAfterUnlock(){
        lock.unlock(PIN);
        lock.lock();
        assertTrue(lock.isLocked());
    }
    @Test
    public void lockShouldNotLockWithWrongPin(){
        final int WRONG_PIN = 1111;
        lock.unlock(WRONG_PIN);
        assertTrue(lock.isLocked());
    }
    @Test
    public void pinCanBeChangedWhileLockIsUnlocked(){
        lock.unlock(PIN);
        final int NEW_PIN = 5678;
        lock.setPin(NEW_PIN);
        lock.lock();
        lock.unlock(NEW_PIN);
        assertFalse(lock.isLocked());
    }



}