package com.github.bombayblues.ctci.ch5;

import java.util.Arrays;

/**
 * Variation of fib(n) where fib(n) = 0,1,2,3,5,8,13,21..., fibT(0,1,1,2,4,7,13,21,...)
 */

public class DynamicProgramming {

    /**
     * Not using Memoization
     *
     * @param n
     * @return
     */
    public static int fibT(final int n) {

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibT(n - 1) + fibT(n - 2) + fibT(n - 3);
        }
    }

    /**
     * Not using memoization
     *
     * @param n
     * @return
     */
    public static int fib(final int n) {

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * Using memoization
     *
     * @param n
     * @return
     */
    public static int fibMemoization(final int n) {

        final int[] array = new int[n + 1];
        Arrays.fill(array, -1);
        return fibMemoization(n, array);
    }

    private static int fibMemoization(final int n, final int[] array) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (array[n] > -1) {
            return array[n];
        } else {
            array[n] = fibMemoization(n - 1, array) + fibMemoization(n - 2, array);
            return array[n];
        }
    }


}
