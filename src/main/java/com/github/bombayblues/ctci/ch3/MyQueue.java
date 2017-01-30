package com.github.bombayblues.ctci.ch3;

/**
 * Simple Queue implementation using linked list
 * <p>
 * Queue is (First In First Out)
 */
public class MyQueue<T> {
    private static class QueueNode<T> {
        T data;
        QueueNode<T> next;

        public QueueNode(final T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    /**
     * Adds item to the queue
     *
     * @param item
     */
    public void add(final T item) {
        final QueueNode<T> node = new QueueNode<T>(item);
        if (this.last != null) {
            this.last.next = node;
        }

        this.last = node;

        if (this.first == null) {
            this.first = this.last;
        }
    }

    /**
     * Remove an item from queue
     *
     * @return
     */
    public T remove() {
        if (this.first == null) {
            return null;
        }

        final T data = this.first.data;
        this.first = this.first.next;

        if (this.first == null) {
            this.last = null;
        }

        return data;
    }

    /**
     * Return the first item in queue
     *
     * @return
     */
    public T peek() {
        return (this.first == null) ? null : this.first.data;
    }

    /**
     * Check if queue is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return this.first == null;
    }
}
