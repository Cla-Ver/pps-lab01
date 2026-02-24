package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    List<Integer> list = new ArrayList<>();
    private final int maxSize;
    public CircularQueueImpl(int maxSize){
        if(maxSize <= 0){
            throw new IllegalArgumentException("List size can only be a positive integer");
        }
        this.maxSize = maxSize;
    }
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(int value) {
        if(list.size() == maxSize){
            list.remove(0);
        }
        list.add(value);
    }

    @Override
    public int dequeue() {
        if(list.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        int n = list.getFirst();
        list.remove(0);
        return n;
    }

    @Override
    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public int peek() {
        return list.getFirst();
    }
}
