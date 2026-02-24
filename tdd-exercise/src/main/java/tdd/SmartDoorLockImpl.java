package tdd;

import java.util.Optional;

public class SmartDoorLockImpl implements SmartDoorLock {
    private Optional<Integer> pin;
    private boolean locked = false;
    private final int MAX_ATTEMPTS = 3;
    private int attemptsCounter = 0;
    public SmartDoorLockImpl(Optional<Integer> pin) {
        this.pin = pin;
    }

    @Override
    public void setPin(int pin) {
        if(locked){
            throw new IllegalStateException("The pin can be changed only when the lock is open");
        }
        this.pin = Optional.of(pin);
    }
    @Override
    public void unlock(int pin) {
        if(this.pin.isEmpty()){
            throw new IllegalStateException("Pin is not set");
        }
        if(this.pin.get() != pin || isBlocked()){
            attemptsCounter = attemptsCounter + 1;
        }
        else {
            locked = false;
            attemptsCounter = 0;
        }
    }
    @Override
    public void lock() {
        locked = true;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public boolean isBlocked() {
        return attemptsCounter >= MAX_ATTEMPTS;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return attemptsCounter;
    }

    @Override
    public void reset() {
        locked = false;
        attemptsCounter = 0;
        pin = Optional.empty();
    }
}
