package com.github.bombayblues.ctci.bigo;

/**
 * Examples from BigO chapter
 * 
 * @author Anoop
 *
 */

public class BigOExamples {

    public void reverse(final int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < (array.length / 2); i++) {
            final int indexA = array.length - i - 1;
            final int tempA = array[i];
            array[i] = array[indexA];
            array[indexA] = tempA;
        }
    }

}
