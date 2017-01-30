package com.github.bombayblues.ctci.bigo;

/**
 * Examples from BigO chapter
 *
 * @author bombayblues
 */

public class BigOExamples {

    /**
     * Inverses integer array
     * <p>
     * Example 6: Pg 48
     * <p>
     * Complexity O(n)
     *
     * @param array
     */
    public void reverse(final int[] array) {
        if (array == null) {
            return;
        }

        // Hint:
        // Start by swapping the first and the last entry in the array.
        // If you let it iteratre for the length of the array it will again swap the first and the
        // last
        for (int i = 0; i < (array.length / 2); i++) {
            final int indexA = array.length - i - 1;
            final int tempA = array[i];
            array[i] = array[indexA];
            array[indexA] = tempA;
        }
    }

    /**
     * What is a prime number?
     * <p>
     * A whole number greater than 1, which is divisible by either 1 or itself.
     * <p>
     * Example 10: Pg 50
     * <p>
     * Complexity O(√n)
     *
     * @param n
     * @return true if its divisible by only 1 or itself
     */
    public boolean isPrime(final int n) {

        // Hint:
        // We have to check until the square root of n because if it is divisible by a number
        // greater than its square root, then its divisible by a number smaller than it suqare root.
        // Example:
        // 33, its divisible by 11 but its also divisible by 3, a much smaller number than its
        // square root
        for (int i = 2; (i * i) <= n; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * The factorial of a non-negative integer n, denoted by n!, is the product of all positive
     * integers less than or equal to n. For example,
     * <p>
     * 5!=5 * 4 * 3 * 2 * 1 = 120.
     * <p>
     * Example 11 : Pg 51
     * <p>
     * Complexity O(n)
     *
     * @param n
     * @return
     */

    public int factorial(final int n) {
        if (n < 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Fibonacci series - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
     * <p>
     * Adding two previous numbers in the series
     * <p>
     * Recurssion: O(2^n)
     *
     * @param n
     * @return
     */

    private int fibonacci(final int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /**
     * Loop through n times to find the fibonacci series for n using recurssion
     *
     * @param n
     * @return
     */
    public int[] fibSeries(final int n) {
        final int[] array = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = fibonacci(i);
        }

        return array;
    }

    /**
     * Using memoization
     *
     * @param n
     * @return
     */
    public int[] memoFibSeries(final int n) {
        final int[] array = new int[n + 1];
        final int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = memoizationFib(i, memo);
        }

        return array;
    }

    /**
     * Memoization, technique to cache previous responses and return it when you find it.
     *
     * @param n
     * @return
     */
    private int memoizationFib(final int n, final int[] memo) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = memoizationFib(n - 1, memo) + memoizationFib(n - 2, memo);
        return memo[n];
    }

}
