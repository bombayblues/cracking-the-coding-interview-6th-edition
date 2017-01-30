package com.github.bombayblues.ctci.ch2;

import java.util.HashSet;
import java.util.Set;

public class MyLinkedList {

    private Node head;

    /**
     * Simple add node to the end of linkedlist
     *
     * @param node
     */
    public void addNode(final Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            Node runner = this.head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = node;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{ ");
        Node runner = this.head;
        while (runner.next != null) {
            sb.append(runner.data).append(" ");
            runner = runner.next;
        }
        sb.append(runner.data).append(" }");

        return sb.toString();
    }

    /**
     * Delete duplicates using Set
     * <p>
     * time complexity O(n)
     *
     * @param
     */
    public void removeDupsEasy() {
        final Set<Integer> set = new HashSet<Integer>();
        Node aHead = this.head;
        Node previous = null;
        while (aHead != null) {
            if (set.contains(aHead.data)) {
                previous.next = aHead.next;
            } else {
                set.add(aHead.data);
                previous = aHead;
            }
            aHead = aHead.next;
        }
    }

    /**
     * space complexity O(1) time complexity O(n^2)
     */
    public void removeDupsNoStore() {
        Node current = this.head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public Node getHead() {
        return this.head;
    }

}
