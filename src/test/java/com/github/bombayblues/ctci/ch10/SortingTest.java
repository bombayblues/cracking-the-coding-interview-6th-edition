package com.github.bombayblues.ctci.ch10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by @author bombayblues on 2/4/17.
 */
public class SortingTest {

    int[] input;
    String result = "[1, 2, 3, 4, 5, 6, 7, 8, 9]";

    @Before
    public void setup() {
        this.input = new int[]{3, 6, 2, 9, 8, 7, 1, 5, 4};
    }


    @Test
    public void bubbleSortTest() {
        Sorting.bubbleSort(this.input);
        Assert.assertEquals(this.result, (Arrays.toString(this.input)));
    }

    @Test
    public void selectionSortTest() {
        Sorting.selectionSort(this.input);
        Assert.assertEquals(this.result, (Arrays.toString(this.input)));
    }

    @Test
    public void insertionSortTest() {
        Sorting.insertionSort(this.input);
        Assert.assertEquals(this.result, (Arrays.toString(this.input)));
    }
}
