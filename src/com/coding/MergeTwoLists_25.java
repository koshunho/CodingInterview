package com.coding;
//25. 合并两个排序的链表
// 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
//示例1：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeTwoLists_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                if(o1.val - o2.val < 0) return -1;
                else if(o1.val == o2.val) return 0;
                else return 1;
            }
        });
        while(l1 != null){
            pq.add(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            pq.add(l2);
            l2 = l2.next;
        }
        ListNode ans = new ListNode(-1);
        ListNode dummyNode = ans;
        while(!pq.isEmpty()){
            dummyNode.next = pq.poll();
            dummyNode = dummyNode.next;
        }
        return ans.next;
    }
}
//思路：这里用了优先队列PriorityQueue，重写了Comparator接口的compare（）方法，这里是最小堆。为升序
//然后遍历所有节点，一起放到pq里面，再取出来就是排好序的了
