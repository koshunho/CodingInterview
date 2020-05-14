package com.coding;

//24. 反转链表
// 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
// 
//
//示例:
//
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
public class ReverseList_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
//思路：这道题可以说是开启了我对于递归理解的大门
//我们先假设n-1个链表已经反转完成了（1->   2<-3<-4<-5），接下来就只需要处理头节点
//所以我们要处理1->2，以及让头结点指向null
//head.next.next = head;
//head.next = null;
//可以看看这篇文章：https://www.cnblogs.com/LiCheng-/p/8206444.html
