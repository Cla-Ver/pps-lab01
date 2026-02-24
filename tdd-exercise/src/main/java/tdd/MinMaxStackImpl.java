package tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {
    List<Integer> list = new ArrayList<>();
    @Override
    public void push(int value) {
        list.add(list.size(), value);
    }

    @Override
    public int pop() {
        if(list.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        int n = list.getLast();
        list.remove(list.size() - 1);
        return n;
    }

    @Override
    public int peek() {
        if(list.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return list.getLast();
    }

    @Override
    public int getMin() {
        if(list.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return list.stream().sorted().findFirst().get();
    }

    @Override
    public int getMax() {
        return list.stream().sorted(Comparator.reverseOrder()).findFirst().get();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
