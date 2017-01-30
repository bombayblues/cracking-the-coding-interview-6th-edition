package com.github.bombayblues.ctci.ch2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LinkedListATest {

    private final static Logger logger = Logger.getLogger(LinkedListATest.class.getSimpleName());

    private List<Node> holder;

    private LinkedListA aLL;

    private Node palindrome;

    @Before

    public void setup() {

        this.holder = new ArrayList<Node>();

        for (int i = 1; i <= 10; i++) {
            final Node a = new Node(i);
            this.holder.add(a);
        }

        this.aLL = new LinkedListA();

        final Node n1 = new Node(1);
        this.aLL.addNode(n1);
        final Node n2 = new Node(3);
        this.aLL.addNode(n2);
        final Node n3 = new Node(5);
        this.aLL.addNode(n3);
        final Node n4 = new Node(6);
        this.aLL.addNode(n4);
        final Node n5 = new Node(3);
        this.aLL.addNode(n5);
        final Node n6 = new Node(7);
        this.aLL.addNode(n6);
        final Node n7 = new Node(5);
        this.aLL.addNode(n7);

        //

        final Node p1 = new Node(0);
        final Node p2 = new Node(1);
        final Node p3 = new Node(2);
        final Node p4 = new Node(1);
        final Node p5 = new Node(0);

        this.palindrome = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
    }

    @Test
    public void simpleTest() {
        final LinkedListA ll = new LinkedListA();

        for (final Node n : this.holder) {
            ll.addNode(n);
        }

        logger.info("Linked List is: " + ll);
    }

    @Test
    public void testRemoveDupsEasy() {
        logger.info("Test Case (Easy): " + this.aLL.toString());
        this.aLL.removeDupsEasy();
        Assert.assertEquals("{ 1 3 5 6 7 }", this.aLL.toString());
        logger.info("Result Case (Easy): " + this.aLL.toString());
    }

    @Test
    public void testRemoveDups() {
        logger.info("Test Case: " + this.aLL.toString());
        this.aLL.removeDupsNoStore();
        Assert.assertEquals("{ 1 3 5 6 7 }", this.aLL.toString());
        logger.info("Result Case: " + this.aLL.toString());
    }

    @Test
    public void testKTHToLast() {
        Assert.assertEquals(7, LinkedListUtil.kTHToLast(this.aLL.getHead(), 2).data);
        Assert.assertEquals(1, LinkedListUtil.kTHToLast(this.aLL.getHead(), 7).data);
    }

    @Test
    public void testDeleteGivenNode() {
        final Node node = this.aLL.getHead().next;
        Assert.assertEquals(true, LinkedListUtil.deleteGivenNode(node));
        Assert.assertEquals("{ 1 5 6 3 7 5 }", this.aLL.toString());
        logger.info("Result Case: " + this.aLL.toString());
    }

    @Test
    public void testPalindrome() {
        Assert.assertTrue(LinkedListUtil.isPalindrome(this.palindrome));
        Assert.assertTrue(LinkedListUtil.isPalindromeWithRunner(this.palindrome));
    }

    @Test
    public void testIntersection() {
        final LinkedListA aList = new LinkedListA();
        final LinkedListA pList = new LinkedListA();

        final Node iNode = new Node(5);

        for (int i = 0; i <= 7; i++) {
            if (i == 5) {
                aList.addNode(iNode);
            } else {
                final Node node = new Node(i);
                aList.addNode(node);
            }
        }

        for (int i = 3; i <= 7; i++) {
            if (i == 5) {
                pList.addNode(iNode);
                break;
            } else {
                final Node node = new Node(i);
                pList.addNode(node);
            }
        }

        Assert.assertEquals(iNode, LinkedListUtil.getIntersectionPoint(aList.getHead(), pList.getHead()));
    }
}
