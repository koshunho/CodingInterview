package com.coding;
//7. 重建二叉树
// 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 
//
//例如，给出
//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//

import java.util.HashMap;

public class BuildTree_07 {
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0; i < len; i++) hm.put(inorder[i], i);
        return build(preorder, hm, 0, len-1);
    }
    TreeNode build(int[] preorder, HashMap <Integer, Integer> hm, int inL, int inR){
        if(inL > inR) return null;
        TreeNode node = new TreeNode(preorder[preorderIndex++]);
        int inorderIndex = hm.get(node.val);
        node.left = build(preorder, hm, inL, inorderIndex - 1);
        node.right = build(preorder, hm, inorderIndex + 1, inR);
        return node;
    }
}
//这题太经典了。首先知道中序 + 前序/后序 能确定唯一的一个二叉树。
//前序/后序 提供下一个根节点，通过中序知道左右子树。
//用HashMap存储 <中序的值，中序的下标>。（注意不包含重复的数字才能这样做）。
//在build()中递归建造出树，注意递归退出的条件 inL > inR
