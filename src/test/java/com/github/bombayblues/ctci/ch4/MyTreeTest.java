package com.github.bombayblues.ctci.ch4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by @author bombayblues on 1/31/17.
 */
public class MyTreeTest {

    @Test
    public void testMinimalBST() {
        final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final BTreeNode root = BTreeUtil.createMinimalBST(array);
        // Assert when we do depth calculation...
        Assert.assertEquals(5, root.data);
        Assert.assertEquals(true, root.isBST());
        Assert.assertEquals(4, root.height());
        Assert.assertEquals(4, BTreeUtil.getHeight(root));
        Assert.assertEquals(true, BTreeUtil.isBalanced(root));
        Assert.assertEquals(true, BTreeUtil.isBalancedEfficient(root));
        Assert.assertEquals(true, BTreeUtil.isBinarySearchTreeSimple(root));
        Assert.assertEquals(true, BTreeUtil.isBinarySearchTreeNoArrays(root));
        BTreePrinter.printNode(root);
        root.printInOrder();
    }
}
