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
    }

}
