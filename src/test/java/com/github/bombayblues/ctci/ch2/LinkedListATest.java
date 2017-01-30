package com.github.bombayblues.ctci.ch2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListATest {

    List<Node> holder = new ArrayList<Node>();

    LinkedListA aLL = new LinkedListA();

    @Before
    public void setup() {
        for (int i = 1; i <= 10; i++) {
            final Node a = new Node(i);
            holder.add(a);
        }

        final Node n1 = new Node(1);
        aLL.addNode(n1);
        final Node n2 = new Node(3);
        aLL.addNode(n2);
        final Node n3 = new Node(5);
        aLL.addNode(n3);
        final Node n4 = new Node(6);
        aLL.addNode(n4);
        final Node n5 = new Node(3);
        aLL.addNode(n5);
        final Node n6 = new Node(7);
        aLL.addNode(n6);
        final Node n7 = new Node(5);
        aLL.addNode(n7);
    }

    @Test
    public void simpleTest() {
        final LinkedListA ll = new LinkedListA();

        for (final Node n : holder) {
            ll.addNode(n);
        }

        System.out.println("Linked List is: " + ll);
    }

    @Test
    public void testRemoveDups() {
        System.out.println("Test Case: " + aLL.toString());
        // aLL.removeDupsEasy();
        aLL.removeDupsNoStore();
        Assert.assertEquals("{ 1 3 5 6 7 }", aLL.toString());
        System.out.println("Result Case: " + aLL.toString());
    }
}
