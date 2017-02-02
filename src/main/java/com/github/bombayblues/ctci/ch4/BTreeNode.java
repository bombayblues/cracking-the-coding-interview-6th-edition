package com.github.bombayblues.ctci.ch4;

/**
 * We can create a separate class for the node and for a Tree similar to how we did graphs, but here its just easy
 * In Graphs its easier to make separate classes.
 */

public class BTreeNode {

    int data;
    BTreeNode left;
    BTreeNode right;

    public BTreeNode(final int data) {
        this.data = data;
    }


    public void printInOrder() {
        printInOrder(this);
    }

    private void printInOrder(final BTreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.data);
            printInOrder(node.right);
        }
    }


    public int height() {
        final int leftHeight = this.left != null ? this.left.height() : 0;
        final int rightHeight = this.right != null ? this.right.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }


    public boolean isBST() {
        if (this.left != null) {
            if (this.data < this.left.data || !this.left.isBST()) {
                return false;
            }
        }

        if (this.right != null) {
            if (this.data >= this.right.data || !this.right.isBST()) {
                return false;
            }
        }

        return true;
    }
}
