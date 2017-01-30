package com.github.bombayblues.ctci.ch3;

import java.util.Stack;

/**
 * Problem:
 * Use two stacks to implement a queue
 * <p>
 * Solution:
 * We maintain two stacks.
 * One stack has all old elements (elements pused before first pop operation)
 * Second stack has all new elements (all push goes here)
 * <p>
 * Example:
 * Say if we start a queue with adding 1 2 3 then perform a remove (dequeue) then again push 4 5
 * Operations should be:
 * <ol>
 * <li>add 1 2 3</li>
 * <li>NewStack = 1 2 3</li>
 * <li>NewStack = 1 2 3</li>
 * <li>OldStack = empty</li>
 * <li>remove</li>
 * <li>Move all NewStack to OldStack</li>
 * <li>NewStack = empty</li>
 * <li>OldStack = 2 3 (1 is removed)</li>
 * <li>add 4 5</li>
 * <li>NewStack = 4 5</li>
 * <li>OldStack = 2 3</li>
 * </ol>
 */
public class MyQueueUsingStack<T> {

    private final Stack<T> newestElements = new Stack<T>();
    private final Stack<T> oldestElements = new Stack<T>();

    /**
     * Simply add an emelent to newest stack
     *
     * @param item
     */
    public void add(final T item) {
        this.newestElements.push(item);
    }

    /**
     * Size is sum of both stacks
     *
     * @return
     */
    public int size() {
        return this.newestElements.size() + this.oldestElements.size();
    }

    public T remove() {
        moveNewestToOld();

        return this.oldestElements.pop();
    }

    public T peek() {
        moveNewestToOld();

        return this.oldestElements.peek();
    }

    /**
     * If oldest is empty, move all newest to oldest and empty newest so it can then contain newer elements
     */
    private void moveNewestToOld() {
        if (this.oldestElements.isEmpty()) {
            while (!this.newestElements.isEmpty()) {
                this.oldestElements.push(this.newestElements.pop());
            }
        }
    }
}
