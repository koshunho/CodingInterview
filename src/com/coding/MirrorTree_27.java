package com.coding;
//27.二叉树的镜像
// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
//例如输入：
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//镜像输出：
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//

public class MirrorTree_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = mirrorTree(root.left);   //假设以root.left为根节点的树全部镜像转好了
        TreeNode right = mirrorTree(root.right); //假设以root.right为根节点的树全部镜像转好了
        root.right = left;                       //那么回到最初的root，只要把root.left 和 root.right调换位置就好了。
        root.left = right;
        return root;
    }
}
//思路：关于二叉树的递归题，总是比较有意思，但是感觉自己常常会绕进去
//还是之前的办法，假设->最后一步如何处理
