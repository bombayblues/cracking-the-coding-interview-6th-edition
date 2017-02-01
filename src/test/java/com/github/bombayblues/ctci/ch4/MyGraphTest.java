package com.github.bombayblues.ctci.ch4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by @author bombayblues on 1/31/17.
 */
public class MyGraphTest {


    /**
     * Example:
     * <p>
     * Cracking the coding interview 6th Edition, Pg 107
     * 0 -> 1 -> 2
     * 0 -> 4
     * 0 -> 5
     * <p>
     * 1 -> 3
     * 1 -> 4
     * <p>
     * 3 -> 2
     * 3 -> 4
     * <p>
     * 2 -> 1
     */

    @Test
    public void testGraphTest() {
        final Node n0 = new Node("0");
        final Node n1 = new Node("1");
        final Node n2 = new Node("2");
        final Node n3 = new Node("3");
        final Node n4 = new Node("4");
        final Node n5 = new Node("5");

        n0.addAdjacent(n1);
        n0.addAdjacent(n4);
        n0.addAdjacent(n5);

        n1.addAdjacent(n3);
        n1.addAdjacent(n4);

        n3.addAdjacent(n2);
        n3.addAdjacent(n4);

        n2.addAdjacent(n1);

        final MyGraph g = new MyGraph();
        g.addNode(n0);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);


        Assert.assertEquals(true, MyGraphUtil.hasRouteBetweenNodes(g, n0, n5));
        Assert.assertEquals(true, MyGraphUtil.hasRouteBetweenNodes(g, n0, n2));
        Assert.assertEquals(false, MyGraphUtil.hasRouteBetweenNodes(g, n5, n0));
        Assert.assertEquals(false, MyGraphUtil.hasRouteBetweenNodes(g, n4, n3));
        Assert.assertEquals(true, MyGraphUtil.hasRouteBetweenNodes(g, n2, n1));
    }

}
