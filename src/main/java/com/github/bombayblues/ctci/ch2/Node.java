package com.github.bombayblues.ctci.ch2;

/**
 * 
 * Simple Node in a linked list
 * 
 * Ideally we should protect instance variables and expose it through accessor methods but to keep
 * it simple we are going to make the variables public
 * 
 * @author Anoop
 *
 */

public class Node {

    public Node next;
    public int data;

    // Simple constructor
    public Node(final int data) {
        this.data = data;
    }

    public Node(final Node node, final int data) {
        this.next = node;
        this.data = data;
    }
}
