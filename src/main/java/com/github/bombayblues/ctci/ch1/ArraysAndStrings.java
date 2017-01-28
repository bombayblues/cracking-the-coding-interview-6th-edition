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

    public boolean isPalindrome(final String str) {
        for (int i = 0; i < (str.length() / 2); i++) {
            final int j = str.length() - 1 - i;
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
