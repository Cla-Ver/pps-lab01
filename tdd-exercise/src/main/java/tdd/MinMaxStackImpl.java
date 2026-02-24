package tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {
    List<Integer> list = new ArrayList<>();
    private void checkEmptyList(){
        if(list.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
    }
    @Override
    public void push(int value) {
        list.add(list.size(), value);
    }

    @Override
    public int pop() {
        checkEmptyList();
        int n = list.getLast();
        list.remove(list.size() - 1);
        return n;
    }

    @Override
    public int peek() {
        checkEmptyList();
        return list.getLast();
    }

    @Override
    public int getMin() {
        checkEmptyList();
        return list.stream().sorted().findFirst().get();
    }

    @Override
    public int getMax() {
        checkEmptyList();
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
