package com.coding;
//55 - I. 二叉树的深度
//
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
//        例如：
//
//        给定二叉树 [3,9,20,null,null,15,7]，
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回它的最大深度 3 。
public class MaxDepth_55_1 {
    int depth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1);
        return depth;
    }
    void helper(TreeNode node, int curDepth){
        if(node == null) return;
        depth = Math.max(depth, curDepth);
        helper(node.left, curDepth + 1);
        helper(node.right, curDepth + 1);
    }
}
//思路：二叉树经典题，有自底向上和自顶向下的方法，有些许的区别