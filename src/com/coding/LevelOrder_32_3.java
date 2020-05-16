package com.coding;
//32 - III. 从上到下打印二叉树 III
// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
//  [20,9],
//  [15,7]
//]
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrder_32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List <List<Integer>> ans = new ArrayList();
        helper(root, ans, 0);
        for(int i = 0; i < ans.size(); i++){
            if((i+1) % 2 == 0){
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
    void helper(TreeNode node, List <List<Integer>> ans, int level){
        if(node == null) return;
        if(level == ans.size()) ans.add(new ArrayList <Integer> ());
        ans.get(level).add(node.val);
        helper(node.left, ans, level + 1);
        helper(node.right, ans, level + 1);
    }
}
//思路：还是先正常层次遍历，然后判断是偶数行的话，再翻转一下就好了