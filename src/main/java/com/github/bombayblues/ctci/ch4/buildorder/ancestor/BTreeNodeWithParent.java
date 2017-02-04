package com.github.bombayblues.ctci.ch4.buildorder.ancestor;

import com.github.bombayblues.ctci.ch4.BTreeNode;

/**
 * Binary tree repesentation of a binary tree node with a parent
 */

public class BTreeNodeWithParent extends BTreeNode {

    private BTreeNodeWithParent parent;

    public BTreeNodeWithParent(final BTreeNodeWithParent parent, final int data) {
        super(data);
        this.parent = parent;
    }

    public BTreeNodeWithParent getParent() {
        return this.parent;
    }

    public void setParent(final BTreeNodeWithParent parent) {
        this.parent = parent;
    }

    public int depth() {
        int depth = 0;
        BTreeNodeWithParent node = this;
        while (node != null) {
            depth++;
            node = node.getParent();
        }

        return depth;
    }

}
