package com.github.bombayblues.ctci.ch10;

/**
 * Created by @author bombayblues on 2/4/17.
 */
public class Sorting {

    /**
     * Bubble Sort:
     * <p>
     * Simplest of all, compare 1st and 2nd element in an array, if 1st is greater than 2nd, swap them.
     * Then, compare next pair, and continue...
     * <p>
     * Complexity:
     * <p>
     * Time: O(n^2)
     * Space: O(1);
     *
     * @param input
     * @return
     */
    public static void bubbleSort(final int[] input) {
        for (int outter = 0; outter < input.length - 1; outter++) {
            for (int inner = 0; inner < input.length - 1 - outter; inner++) {
                if (input[inner] > input[inner + 1]) {
                    swap(input, inner, inner + 1);
                }
            }
        }
    }

    private static void swap(final int[] input, final int i, final int j) {
        final int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }


    /**
     * Selection Sort:
     * <p>
     * Find the smallest element using linear sort and move it to the front.
     * Then pick the next element.
     * <p>
     * Time: O(n^2)
     * Space: O(1);
     *
     * @param input
     */
    public static void selectionSort(final int[] input) {
        int minValue, minIndex;
        for (int outter = 0; outter < input.length; outter++) {
            minValue = input[outter];
            minIndex = outter;
            for (int inner = outter; inner < input.length; inner++) {
                if (input[inner] < minValue) {
                    minValue = input[inner];
                    minIndex = inner;
                }
            }

            if (minValue < input[outter]) {
                swap(input, minIndex, outter);
            }
        }
    }

    /**
     * Insertion Sort:
     * <p>
     * Compare the elements to the left, if the element on left is less than the current, swap.
     * <p>
     * Time: O(n^2)
     *
     * @param input
     */
    public static void insertionSort(final int[] input) {
        int inner, value;
        for (int outter = 1; outter < input.length; outter++) {
            inner = outter - 1;
            value = input[outter];

            while (inner >= 0 && value < input[inner]) {
                swap(input, inner, inner + 1);
                inner--;
            }
        }
    }
}
