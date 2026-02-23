package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    @Test
    public void lockShouldBeInitiallyLocked(){
        SmartDoorLock lock = new SmartDoorLockImpl(1234);
        assertTrue(lock.isLocked());
    }
}