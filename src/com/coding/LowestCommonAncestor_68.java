package com.coding;
//68 - I. 二叉树的最近公共祖先
// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//（二叉搜索树自然也是二叉树，这是通解）
//最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//示例 1:
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//        输出: 3
//        解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//        示例 2:
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//        输出: 5
//        解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//         
//
//        说明:
//
//        所有节点的值都是唯一的。
//        p、q 为不同节点且均存在于给定的二叉树中。



public class LowestCommonAncestor_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);  //如果左右返回值只有一个不为null。说明P、Q存在左 or 右 子树
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
//思路：RPQ理论：若P为P何Q的最近公共祖先，那么P和Q一定位于R的不同子树上，或者P/Q之一为R
//对于任一节点R，如果分别在其左子树和柚子树中有3种可能：
//1.左右子树都找到了，返回值非空，说明P、Q分别在左右子树，直接返回R
//2.P、Q之一为R，说明R就是LCA，返回R
//3.只在左子树中找到，说明P、Q都在左子树，递归查找左子树，知道1、2情况出现
//4.同理， 右子树
