package com.github.bombayblues.ctci.ch1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArraysAndStrings {

    /**
     * Using hash set
     * 
     * O(n)
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

    /**
     * Rotate matrix by 90 degrees
     * 
     * @param matrix
     * @return
     */
    public int[][] rotateMatrixBy90Degree(final int[][] matrix) {
        printMatrix(matrix);
        if ((matrix.length == 0) || (matrix.length != matrix[0].length)) {
            return null;
        }
        final int n = matrix.length;

        for (int layer = 0; layer < (n / 2); layer++) {
            final int first = layer;
            final int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                final int offset = i - first;
                final int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }

        System.out.println("Matrix After Rotating 90 degree:-");
        printMatrix(matrix);
        return matrix;

    }

    /**
     * Helper function to print matrix on console for ease of understanding
     * 
     * @param matrix
     */
    private void printMatrix(final int[][] matrix) {
        final StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < matrix.length; i++) {
            sb.append("{ ");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("}\n");
        }
        sb.append("};");
        System.out.println(sb.toString());
    }

    public int[][] zeroMatrix(final int[][] matrix) {
        final int nRows = matrix.length;
        final int nCols = matrix[0].length;

        final boolean[] rows = new boolean[nRows];
        final boolean[] cols = new boolean[nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // nullify rows
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                nullifyRow(matrix, i);
            }
        }

        // nullify columns
        for (int j = 0; j < cols.length; j++) {
            if (cols[j]) {
                nullifyColumn(matrix, j);
            }
        }

        return matrix;
    }

    private void nullifyRow(final int[][] matrix, final int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private void nullifyColumn(final int[][] matrix, final int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    /**
     * Check if string s2 is a rotation for string s1
     * 
     * Hint: if we concatenate s1to s1 such that s1s1, then s2 will be a substring of s1s1.
     * 
     * @param aStr
     * @param pStr
     * @return
     */
    public boolean isRotation(final String aStr, final String pStr) {
        if ((aStr == null) || (pStr == null)) {
            return false;
        }
        final int len = aStr.length();
        if (len == pStr.length()) {
            final String aStrs = aStr + aStr;
            return aStrs.contains(pStr);
        }

        return false;
    }

}
