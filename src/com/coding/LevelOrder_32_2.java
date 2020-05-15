package com.coding;

import java.util.ArrayList;
import java.util.List;

//32 - II. 从上到下打印二叉树 II
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
// 
//
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//

public class LevelOrder_32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List <List<Integer>> ans = new ArrayList();
        helper(root, ans, 0);
        return ans;
    }
    void helper(TreeNode node, List <List<Integer>> ans, int level){
        if(node == null) return;
        if(ans.size() == level) ans.add(new ArrayList <Integer> ());
        ans.get(level).add(node.val);
        helper(node.left, ans, level + 1);
        helper(node.right, ans, level + 1);
    }
}
//思路：跟31-1一样，返回值不同而已