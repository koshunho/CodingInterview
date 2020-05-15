package com.coding;

import java.util.ArrayList;
import java.util.List;

//32 - I. 从上到下打印二叉树
// 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
//返回：
//
//[3,9,20,15,7]
//
public class LevelOrder_32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int[] levelOrder(TreeNode root) {
        List <List<Integer>> lists = new ArrayList();
        helper(root, lists, 0);
        List <Integer> ans = new ArrayList();
        for(List <Integer> list: lists){
            for(int i = 0; i < list.size(); i++){
                ans.add(list.get(i));
            }
        }
        int [] res = new int [ans.size()];
        for(int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }
    void helper(TreeNode node, List <List<Integer>> ans, int level){
        if(node == null) return;
        if(level == ans.size()) ans.add(new ArrayList <Integer> ());
        ans.get(level).add(node.val);
        helper(node.left, ans, level + 1);
        helper(node.right, ans, level + 1);
    }
}
//思路：没啥好说的，最基础的层次遍历