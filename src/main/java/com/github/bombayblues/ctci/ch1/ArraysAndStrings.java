package com.github.bombayblues.ctci.ch1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArraysAndStrings {

    /**
     * Using hash set
     * 
     * @param str
     * @return
     */

    public boolean hasUniqueCharsEasy(final String str) {
        final Set<Character> charSet = new HashSet<Character>();

        // Add each char in a set, if it does not add that means it has the char already and is not
        // unique
        for (final char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Using biwise operator
     * 
     * @param str
     * @return
     */
    public boolean hasUniqueBitOp(final String str) {
        if (str.length() > 256) {
            return false;
        }
        final boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            final int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public boolean isPermutation(final String aStr, final String pStr) {

        if (aStr.length() != pStr.length()) {
            return false;
        }

        final Map<Character, Integer> db = new HashMap<Character, Integer>();

        for (final char c : aStr.toCharArray()) {
            db.put(c, db.get(c) == null ? 1 : db.get(c) + 1);
        }

        for (final char c : pStr.toCharArray()) {
            db.put(c, db.get(c) == null ? -1 : db.get(c) - 1);
        }

        for (final char c : aStr.toCharArray()) {
            if (db.get(c) != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * True if reverse is same as in kayak
     * 
     * @param str
     * @return
     */

    public boolean isPalindrome(final String str) {
        for (int i = 0; i < (str.length() / 2); i++) {
            final int j = str.length() - 1 - i;
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Given two strings find if they are one or zero edits away.
     * 
     * @param aStr
     * @param pStr
     * @return
     */
    public boolean areOneEditStrings(final String aStr, final String pStr) {
        // Check lebgth
        if (Math.abs(aStr.length() - pStr.length()) > 1) {
            return false;
        }

        final String s1 = aStr.length() < pStr.length() ? aStr : pStr;
        final String s2 = aStr.length() < pStr.length() ? pStr : aStr;

        int aIndex = 0;
        int pIndex = 0;
        boolean foundDifference = false;
        while ((aIndex < s1.length()) && (pIndex < s2.length())) {
            if (s1.charAt(aIndex) != s2.charAt(pIndex)) {
                // Allow the flag to be toggled only once
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    aIndex++;
                }
            } else {
                aIndex++; // If matching, move shorter pointer
            }
            pIndex++; // Always move pointer for longer string
        }
        return true;
    }

    /**
     * Basic string compression usinf counts of repeated chars. Example: aabcccdd will become
     * a2b1c3d2
     * 
     * @param str
     * @return
     */

    public String basicCompression(final String str) {
        int counter = 0;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            counter++;
            if ((i + 1) >= str.length()) {
                sb.append(str.charAt(i)).append(counter);
                break;
            }
            if (str.charAt(i + 1) == str.charAt(i)) {
                continue;
            } else {
                sb.append(str.charAt(i)).append(counter);
                counter = 0;
            }
        }

        return sb.toString();
    }
}
