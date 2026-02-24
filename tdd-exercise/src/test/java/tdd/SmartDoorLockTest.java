package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    SmartDoorLock lock;
    private final int PIN = 1234;
    private final int WRONG_PIN = 1111;
    private final int NEW_PIN = 5678;
    @BeforeEach
    public void init(){
        lock = new SmartDoorLockImpl();
        lock.setPin(PIN);
    }
    @Test
    public void lockShouldBeInitiallyUnlocked(){
        assertFalse(lock.isLocked());
    }
    @Test
    public void lockShouldUnlockWithRightPin(){
        lock.lock();
        lock.unlock(PIN);
        assertFalse(lock.isLocked());
    }
    @Test
    public void lockShouldUnlockWhileUnlocked(){
        lock.lock();
        lock.unlock(PIN);
        lock.unlock(PIN);
        assertFalse(lock.isLocked());
    }
    @Test
    public void lockShouldLockAfterUnlock(){
        lock.lock();
        lock.unlock(PIN);
        lock.lock();
        assertTrue(lock.isLocked());
    }
    @Test
    public void lockShouldNotUnlockWithWrongPin(){
        lock.lock();
        lock.unlock(WRONG_PIN);
        assertTrue(lock.isLocked());
    }
    @Test
    public void pinCanBeChangedWhileLockIsUnlocked(){
        lock.lock();
        lock.unlock(PIN);
        lock.setPin(NEW_PIN);
        lock.lock();
        lock.unlock(NEW_PIN);
        assertFalse(lock.isLocked());
    }
    @Test
    public void lockShouldThrowExceptionIfChangingPinWhenLocked(){
        lock.lock();
        assertThrows(IllegalStateException.class, () -> lock.setPin(NEW_PIN));
    }
    @Test
    public void lockShouldInitiallyBeUnblocked(){
        assertFalse(lock.isBlocked());
    }
    private void blockLock(){
        for(int counter = 0; counter <= lock.getMaxAttempts(); counter++){
            lock.unlock(WRONG_PIN);
        }
    }
    @Test
    public void lockShouldBlockOnTooManyFailedAttempts(){
        lock.lock();
        blockLock();
        assertTrue(lock.isBlocked());
    }
    @Test
    public void lockShouldNotUnlockWhileBlocked(){
        lock.lock();
        blockLock();
        lock.unlock(PIN);
        assertTrue(lock.isLocked());
    }
    @Test
    public void lockShouldUnblockOnReset(){
        lock.lock();
        blockLock();
        lock.reset();
        assertFalse(lock.isLocked());
    }
    @Test
    public void lockShouldResetAttemptsOnReset(){
        lock.lock();
        lock.unlock(WRONG_PIN);
        lock.reset();
        assertEquals(0, lock.getFailedAttempts());
    }
    @Test
    public void lockShouldThrowExceptionOnUnlockAfterResetWithNoPinChosen(){
        lock.reset();
        assertThrows(IllegalStateException.class, () -> lock.unlock(PIN));
    }
    @Test
    public void lockShouldUnlockWithNewPinAfterReset(){
        lock.reset();
        lock.setPin(NEW_PIN);
        lock.lock();
        lock.unlock(NEW_PIN);
        assertFalse(lock.isLocked());
    }
}