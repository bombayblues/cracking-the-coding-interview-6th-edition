package com.github.bombayblues.ctci.ch3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test class to test Stack exercises
 */
public class MyStackTest {

    private int[] testArray;
    private FixedMultiStack<Integer> aStack;
    private StackMin mStack;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        this.testArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};

        this.aStack = new FixedMultiStack<Integer>(3);
        for (int i = 0; i < 3; i++) {
            this.aStack.push(0, i);
        }

        for (int i = 3; i < 6; i++) {
            this.aStack.push(1, i);
        }

        for (int i = 6; i < 9; i++) {
            this.aStack.push(2, i);
        }

        this.mStack = new StackMin();
        this.mStack.push(5);
        this.mStack.push(6);
        this.mStack.push(3);
        this.mStack.push(7);
    }

    @Test
    public void testFixedMultiStack() {
        Assert.assertEquals(new Integer(2), (Integer) this.aStack.peek(0));
        Assert.assertEquals(new Integer(5), (Integer) this.aStack.peek(1));
        Assert.assertEquals(new Integer(8), (Integer) this.aStack.peek(2));

        Assert.assertTrue(this.aStack.isFull(0));
        Assert.assertTrue(this.aStack.isFull(1));
        Assert.assertTrue(this.aStack.isFull(2));

        for (int i = 0; i < 3; i++) {
            this.aStack.pop(2);
        }

        this.expectedException.expect(RuntimeException.class);
        this.aStack.pop(2);
    }

    @Test
    public void testStackMin() {
        Assert.assertEquals(new Integer(3), this.mStack.minValue());
        Assert.assertEquals(new Integer(7), this.mStack.pop());
        Assert.assertEquals(new Integer(3), this.mStack.minValue());
        Assert.assertEquals(new Integer(3), this.mStack.pop());
        Assert.assertEquals(new Integer(5), this.mStack.minValue());
    }
}
