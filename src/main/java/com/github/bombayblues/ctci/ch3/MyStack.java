package com.github.bombayblues.ctci.ch3;

/**
 * Simple stack implementation using linked list
 * <p>
 * Stack is (First In Last Out)
 *
 * @param <T>
 */
public class MyStack<T> {

    private static class StackNode<T> {
        private final T data;
        private StackNode<T> next;

        public StackNode(final T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    /**
     * Push item to the top of stack
     *
     * @param item
     */
    public void push(final T item) {
        final StackNode<T> node = new StackNode<T>(item);
        node.next = this.top;
        this.top = node;
    }

    /**
     * Pop item from top of stack
     *
     * @return
     */
    public T pop() {
        if (this.top == null) {
            return null;
        }

        final T data = this.top.data;
        this.top = this.top.next;

        return data;
    }

    /**
     * Look at the item on top of stack
     *
     * @return
     */
    public T peek() {
        return (this.top == null) ? null : this.top.data;
    }

    /**
     * Check if stack is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return this.top == null;
    }
}
