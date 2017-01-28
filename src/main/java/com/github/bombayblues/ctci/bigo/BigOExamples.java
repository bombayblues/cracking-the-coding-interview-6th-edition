package com.github.bombayblues.ctci.bigo;

/**
 * Examples from BigO chapter
 * 
 * @author Anoop
 *
 */

public class BigOExamples {

    /**
     * Inverses integer array
     * 
     * Example 6: Pg 48
     * 
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
     * 
     * A whole number greater than 1, which is divisible by either 1 or itself.
     * 
     * Example 10: Pg 50
     * 
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

}
