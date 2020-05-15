package com.coding;
//33. 二叉搜索树的后序遍历序列
// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
// 
//
//参考以下这颗二叉搜索树：
//
//     5
//    / \
//   2   6
//  / \
// 1   3
//示例 1：
//
//输入: [1,6,3,2,5]
//输出: false
//示例 2：
//
//输入: [1,3,2,6,5]
//输出: true
//
public class VerifyPostorder_33 {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if(len <= 1) return true;
        return helper(postorder, 0, len - 1);
    }
    boolean helper(int[] postorder, int start, int end){
        if(start >= end) return true;    //能顺利遍历完，就true

        int i;    //找到第一个大于postorder[end]的下标。就是柚子树的开始
        for(i = start; i < end; i++){
            if(postorder[i] > postorder[end]) break;
        }

        for(int j = i; j < end; j++){
            if(postorder[j] < postorder[end]){
                return false;
            }
        }
        return helper(postorder, start, i - 1) && helper(postorder, i, end - 1); // 再分别判断左子树和柚子树。 注意此处 左右 子树 是怎么划分的！！！！！！！！ 柚子树是(i, end - 1)！！！！！！
    }
}

//思路：好题！很考验递归想法
// 二叉搜索树：对于根节点root，左子树所有的节点的值都小于root.val，柚子树所有的节点的值都大于root.val
//左右子树分别也是二叉搜索树（题外话：二叉搜索树的中序遍历会输出一个升序数组
//题目是给二叉树的后序遍历，左->右->根，数组的最后一个元素就是根节点
//先找出找到第一个大于postorder[end]的下标i（此时已经验证左子树的正确性）。就是柚子树的开始
//验证柚子树的元素是不是都比root.val大
//【start，i-1】就是左子树的区间，【i，end-1】就是柚子树的区间