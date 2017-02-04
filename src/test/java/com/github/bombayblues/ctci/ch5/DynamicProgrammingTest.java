package com.github.bombayblues.ctci.ch5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by @author bombayblues on 2/4/17.
 */
public class DynamicProgrammingTest {

    @Test
    public void fibTest() {
        Assert.assertEquals(13, DynamicProgramming.fib(7));
        Assert.assertEquals(13, DynamicProgramming.fibMemoization(7));
    }

    @Test
    public void testTowerOfHanoi() {
        final TowerOfHanoi towerOfHanoi = new TowerOfHanoi(7);
        towerOfHanoi.solve(7);
        final TowerOfHanoi.Tower[] towers = towerOfHanoi.getTowers();
        Assert.assertTrue(towers[0].getDisks().isEmpty());
        Assert.assertTrue(towers[1].getDisks().isEmpty());
        Assert.assertFalse(towers[2].getDisks().isEmpty());

        final TowerOfHanoi.Tower destination = towers[2];
        final Stack<Integer> stack = destination.getDisks();
        for (int i = 0; i < 7; i++) {
            Assert.assertEquals(i, stack.get(6 - i).intValue());
        }
    }

}
