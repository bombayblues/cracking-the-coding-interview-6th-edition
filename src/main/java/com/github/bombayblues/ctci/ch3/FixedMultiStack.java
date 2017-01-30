package com.github.bombayblues.ctci.ch3;

/**
 * Problem:
 * Three in one - Implement 3 stacks in a single array.
 * <p>
 * Solution:
 * Divide an array in 3 equal parts and then let the individual stack to grow in that space.
 * <p>
 * Example:
 * <p>
 * Assume an array with with 3 stacks with 3 items in each
 * <p>
 * {0, 1, 2, 3, 4, 5, 6, 7, 8}
 * <p>
 * Stack 1 - {0, 1, 2}
 * Stack 2 - {3, 4, 5}
 * Stack 3 - {6, 7, 8}
 */
public class FixedMultiStack<T> {

    private final int numberOfStacks = 3;
    private final int stackCapacity;
    private final int[] sizes;
    private final T[] values;

    public FixedMultiStack(final int stackSize) {
        this.stackCapacity = stackSize;
        this.sizes = new int[this.numberOfStacks];
        this.values = (T[]) new Object[this.stackCapacity * this.numberOfStacks];
    }


    public int indexOfTop(final int stackNumber) {
        final int offset = stackNumber * this.stackCapacity; // say looking up stack 1 so 1 * 3 = 3
        final int size = this.sizes[stackNumber]; // say we have 2 items in it so number will be 2.

        return offset + size - 1; // 4
    }

    public boolean isFull(final int stackNumber) {
        if (stackNumber > 2) {
            throw new IllegalArgumentException("Stack number should be between 0 - 2 as we only support 3 in this one");
        }

        return this.sizes[stackNumber] == this.stackCapacity;
    }

    public boolean isEmpty(final int stackNumber) {
        if (stackNumber > 2) {
            throw new IllegalArgumentException("Stack number should be between 0 - 2 as we only support 3 in this one");
        }

        return this.sizes[stackNumber] == 0;
    }

    public void push(final int stackNumber, final T data) {
        if (isFull(stackNumber)) {
            throw new RuntimeException("Stack full");
        }

        final int topIndex = indexOfTop(stackNumber);
        this.sizes[stackNumber]++; // increment stacks size
        this.values[topIndex + 1] = data;
    }

    public T pop(final int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new RuntimeException("Stack empty");
        }

        final int topIndex = indexOfTop(stackNumber);
        final T value = this.values[topIndex];
        this.sizes[stackNumber]--;
        this.values[topIndex] = null;

        return value;
    }

    public T peek(final int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new RuntimeException("Stack empty");
        }

        final int topIndex = indexOfTop(stackNumber);
        return this.values[topIndex];
    }
}
