package com.github.bombayblues.ctci.ch3;

/**
 * Created by @author bombayblues on 1/30/17.
 */
public class StackMin extends MyStack<Integer> {
    private final MyStack<Integer> stackOfMins;

    public StackMin() {
        this.stackOfMins = new MyStack<Integer>();
    }

    @Override
    public void push(final Integer data) {
        if (data <= minValue()) {
            this.stackOfMins.push(data);
        }
        super.push(data);
    }

    @Override
    public Integer pop() {
        if (super.isEmpty()) {
            throw new RuntimeException("Stack empty");
        }

        final Integer result = super.pop();

        if (result == minValue()) {
            this.stackOfMins.pop();
        }

        return result;
    }

    public Integer minValue() {
        if (this.stackOfMins.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return this.stackOfMins.peek();
        }
    }

}
