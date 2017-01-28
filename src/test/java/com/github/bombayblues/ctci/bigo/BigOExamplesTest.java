package com.github.bombayblues.ctci.bigo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BigOExamplesTest {

    BigOExamples bigOExamples;
    int[] array;
    Map<Integer, Boolean> testDataPirimes;
    int[] fibResult;

    @Before
    public void setUp() {
        bigOExamples = new BigOExamples();

        array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        testDataPirimes = new HashMap<Integer, Boolean>();
        testDataPirimes.put(1, true);
        testDataPirimes.put(2, true);
        testDataPirimes.put(3, true);
        testDataPirimes.put(4, false);
        testDataPirimes.put(5, true);
        testDataPirimes.put(6, false);
        testDataPirimes.put(7, true);
        testDataPirimes.put(8, false);
        testDataPirimes.put(9, false);
        testDataPirimes.put(10, false);
        testDataPirimes.put(11, true);

        fibResult = new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
    }

    @Test
    public void testReverse() {

        bigOExamples.reverse(array);
        Assert.assertArrayEquals(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, array);
    }

    @Test
    public void testPrimes() {
        final Set<Map.Entry<Integer, Boolean>> keys = testDataPirimes.entrySet();
        for (final Map.Entry<Integer, Boolean> entry : keys) {
            Assert.assertSame(String.format("%d is Prime %s", entry.getKey(), entry.getValue()),
                              bigOExamples.isPrime(entry.getKey()), entry.getValue());
        }
    }

    @Test
    public void testFactorial() {
        Assert.assertSame(120, bigOExamples.factorial(5));
    }

    @Test
    public void testFib() {
        Assert.assertArrayEquals(fibResult, bigOExamples.fibSeries(15));
        Assert.assertArrayEquals(fibResult, bigOExamples.memoFibSeries(15));
    }
}
