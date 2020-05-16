package com.coding;

import java.util.Stack;

//6.从尾到头打印链表
// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
//示例 1：
//
//输入：head = [1,3,2]
//输出：[2,3,1]

public class ReversePrint_06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int len = stack.size();
        int [] ans = new int [len];
        for(int i = 0; i < len; i++){
            ans[i] = stack.pop();
        }
        return ans;
    }
}
//思路：这道题的做法就比较多了。
//1.遍历，用一个List来装，最后Collection.reverse()输出
//2.用栈