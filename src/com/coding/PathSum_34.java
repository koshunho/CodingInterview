package com.coding;
//34. 二叉树中和为某一值的路径
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
// 
//
//示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//返回:
//
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
//

import java.util.ArrayList;
import java.util.List;

public class PathSum_34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList();
        helper(root, sum, 0, ans, new ArrayList <Integer> ());
        return ans;
    }
    void helper(TreeNode node, int sum, int curSum, List <List<Integer>> ans, List<Integer> curList){
        if(node == null) return;
        curList.add(node.val);
        if(curSum + node.val == sum && node.left == null && node.right == null) ans.add(new ArrayList (curList));
        helper(node.left, sum, curSum + node.val, ans, curList);
        helper(node.right, sum, curSum + node.val, ans, curList);
        curList.remove(curList.size() - 1);
    }
}
//思路：经典回溯