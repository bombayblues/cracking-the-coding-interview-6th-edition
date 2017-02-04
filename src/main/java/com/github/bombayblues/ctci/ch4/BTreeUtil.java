package com.github.bombayblues.ctci.ch4;

import com.github.bombayblues.ctci.ch4.buildorder.ancestor.BTreeNodeWithParent;

import java.util.ArrayList;

/**
 * Created by @author bombayblues on 2/1/17.
 */
public class BTreeUtil {


    /**
     * Problem:
     * Given a sorted array idea is to create a binary search tree with minimal height.
     * <p>
     * Solution:
     * Idea is to pick the middle element in the sorted array and make it as root,.
     * Insert into left subtree all elements on the left of this element
     * Insert into right subtree all elements on the right of this element
     * Recurse
     *
     * @param array
     * @return
     */

    public static BTreeNode createMinimalBST(final int[] array) {

        // If array not sorted we can sort here with handy method...
        //Arrays.sort(array);

        return createMinimalBST(array, 0, array.length - 1);
    }

    private static BTreeNode createMinimalBST(final int[] array, final int start, final int end) {
        if (end < start) {
            return null;
        } // error case

        final int mid = (start + end) / 2;
        final BTreeNode n = new BTreeNode(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);

        return n;
    }

    /**
     * Problem:
     * <p>
     * Find the depth of a tree or height of a tree.
     * <p>
     * Solution:
     * For each root we find the height of left and right nodes, whichever is bigger we take that and add 1.
     * We do so recursively
     * If the child node is null we return zero
     *
     * @param root
     * @return
     */
    public static int getHeight(final BTreeNode root) {
        if (root == null) {
            return 0; // base case
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }


    /**
     * Problem:
     * <p>
     * Check if a given binary tree is balanced
     * (Assume its balanced if the two subtrees of a node does not differ more than 1.
     * <p>
     * Solution:
     * <p>
     * We calculate the height of left and right nodes, and then check if they differ by more than 1, if so its not balanced,
     * else do recursively for its children.
     * Return true if reach the leaf nodes.
     * <p>
     * Complexity:
     * O(n logn)
     *
     * @param root
     */

    public static boolean isBalanced(final BTreeNode root) {
        if (root == null) {
            return true; // base case;
        }

        final int dHeight = getHeight(root.left) - getHeight(root.right);

        if (Math.abs(dHeight) > 1) {
            //System.out.println(String.format("Root: %d, Left: %d, Right: %d", root.data, ((root.left == null) ? null : root.left.data),(root.right == null) ? null : root.right.data));
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private static int checkHeight(final BTreeNode root) {
        // Base case
        if (root == null) {
            return -1;
        }

        final int lHeight = checkHeight(root.left);
        if (lHeight == Integer.MIN_VALUE) {
            return lHeight;
        }

        final int rHeight = checkHeight(root.right);
        if (rHeight == Integer.MIN_VALUE) {
            return rHeight;
        }

        final int diff = Math.abs(lHeight - rHeight);

        if (diff > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(checkHeight(root.left), checkHeight((root.right)));
        }

    }

    public static boolean isBalancedEfficient(final BTreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    /**
     * Problem:
     * <p>
     * Check if the tree is a binary search tree.
     * In BST, all the elemennts to its left are less than or equal to the root,
     * and all the elements to its right are greater than the root.
     * <p>
     * Solution:
     * <p>
     * Easy solution is to traverse in-order and then copy it to an array.
     * Then check if all elements in an array are sorted.
     *
     * @param root
     * @return
     */
    public static boolean isBinarySearchTreeSimple(final BTreeNode root) {

        final ArrayList<Integer> array = new ArrayList<Integer>();


        copyToArrayUsingInOrderTraversal(root, array);

        System.out.println("Array: " + array);
        // Once we have an array, check if its sorted.
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i + 1) < array.get(i)) {
                return false;
            }
        }

        return true;
    }

    private static void copyToArrayUsingInOrderTraversal(final BTreeNode root, final ArrayList<Integer> array) {
        // Base case
        if (root == null) {
            return;
        }

        copyToArrayUsingInOrderTraversal(root.left, array);
        array.add(root.data);
        copyToArrayUsingInOrderTraversal(root.right, array);
    }

    /**
     * Problem:
     * <p>
     * Check if a given binary tree is balanced
     * (Assume its balanced if the two subtrees of a node does not differ more than 1.
     * <p>
     * Solution:
     * <p>
     * Here we dont have an array to check.
     * Idea here is that theres a MIN and a MAX.
     * At first both are set to NULL
     * Then, we check that
     * <p>
     * Complexity:
     * O(n logn)
     *
     * @param root
     */
    public static boolean isBinarySearchTreeNoArrays(final BTreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.data > root.data || !isBinarySearchTreeNoArrays(root.left)) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.data <= root.data || !isBinarySearchTreeNoArrays(root.right)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Problem:
     * <p>
     * Find common anccestor for two nodes in a binary tree;
     * <p>
     * Solution:
     * <p>
     * Idea is to use similar logic as in the logic of finding the node where two linked lists intersect (2.7)
     */
    public BTreeNodeWithParent commonAncestor(final BTreeNodeWithParent pNode, final BTreeNodeWithParent qNode) {

        //1. Find depth of the two nodes.
        int pDepth = pNode.depth();
        final int qDepth = qNode.depth();

        BTreeNodeWithParent first = (pDepth > qDepth) ? pNode : qNode;
        BTreeNodeWithParent second = (pDepth > qDepth) ? pNode : qNode;

        // 2. Make both the nodes start at same level
        while (pDepth != qDepth && first != null) {
            first = first.getParent();
            pDepth--;
        }

        // 3. Find where they intersect

        while (first != null && second != null && first != second) {
            first = first.getParent();
            second = second.getParent();
        }

        return first != null || second == null ? null : first;
    }
}
