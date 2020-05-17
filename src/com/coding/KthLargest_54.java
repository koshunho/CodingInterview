package com.coding;
//54. 二叉搜索树的第k大节点
// 给定一棵二叉搜索树，请找出其中第k大的节点。
//
// 
//
//示例 1:
//
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4
//示例 2:
//
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4

import java.util.ArrayList;
import java.util.List;

public class KthLargest_54 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList();
        helper(root, inorder);
        return inorder.get(inorder.size() - k);
    }
    void helper(TreeNode node, List <Integer> inorder){
        if(node == null) return;
        helper(node.left, inorder);
        inorder.add(node.val);
        helper(node.right, inorder);
    }
}
//思路：我写的是比较笨的办法，就是先用一个list装BTS的中序遍历（前面提到过了，BTS的中序遍历会输出一个升序数组
//然后list.get(list.size()-k)就能得出第K大的元素了