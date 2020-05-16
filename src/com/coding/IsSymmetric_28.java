package com.coding;
//28.对称的二叉树
// 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
//
// 
//
//示例 1：
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//示例 2：
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false

public class IsSymmetric_28 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    boolean helper(TreeNode A, TreeNode B){
        if(A == null && B == null) return true;
        if(A == null || B == null) return false;

        if(A.val != B.val) return false;
        return helper(A.left, B.right) && helper(A.right, B.left);
    }
}
//思路：这题有点像SQL的自连接（笑
//注意&&的短路效应