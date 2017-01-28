package com.github.bombayblues.ctci.bigo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BigOExamplesTest {

    int[] array;

    @Before
    public void setUp() {
        array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    }

    @Test
    public void testReverse() {
        final BigOExamples bigOExamples = new BigOExamples();
        bigOExamples.reverse(array);
        Assert.assertArrayEquals(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, array);
    }
}
