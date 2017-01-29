package com.github.bombayblues.ctci.ch1;

import org.junit.Assert;
import org.junit.Test;

public class ArraysAndStringsTest {

    ArraysAndStrings arraysAndStrings = new ArraysAndStrings();

    @Test
    public void testUnique() {
        Assert.assertEquals(false, arraysAndStrings.hasUniqueCharsEasy("london"));
        Assert.assertEquals(true, arraysAndStrings.hasUniqueCharsEasy("new york"));

        Assert.assertEquals(false, arraysAndStrings.hasUniqueBitOp("london"));
        Assert.assertEquals(true, arraysAndStrings.hasUniqueBitOp("new york"));

        Assert.assertEquals(true, arraysAndStrings.isPermutation("london", "nodlon"));

        Assert.assertEquals(false, arraysAndStrings.isPalindrome("london"));
        Assert.assertEquals(true, arraysAndStrings.isPalindrome("hannah"));

        Assert.assertEquals(true, arraysAndStrings.areOneEditStrings("pale", "ple"));
        Assert.assertEquals(true, arraysAndStrings.areOneEditStrings("pales", "pale"));
        Assert.assertEquals(true, arraysAndStrings.areOneEditStrings("pale", "bale"));
        Assert.assertEquals(false, arraysAndStrings.areOneEditStrings("pale", "bake"));

        Assert.assertEquals("a2b1c3d2", arraysAndStrings.basicCompression("aabcccdd"));
        Assert.assertEquals("a2b1c3d1", arraysAndStrings.basicCompression("aabcccd"));
        Assert.assertEquals("a2b1c3d3", arraysAndStrings.basicCompression("aabcccddd"));

        final int[][] twoDArray = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        final int[][] rotate90Deg = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };

        Assert.assertArrayEquals(rotate90Deg, arraysAndStrings.rotateMatrixBy90Degree(twoDArray));

        Assert.assertEquals(true, arraysAndStrings.isRotation("waterbottle", "erbottlewat"));
    }

}
