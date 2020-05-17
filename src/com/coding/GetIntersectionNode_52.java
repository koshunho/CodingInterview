package com.coding;
//52. 两个链表的第一个公共节点
//示例一
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

public class GetIntersectionNode_52 {
    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode node1 = headA, node2 = headB;
        while(node1 != node2){ //巧妙
            node1 = node1 == null? headB : node1.next;
            node2 = node2 == null? headA : node2.next;
        }
        return node1;
    }
}
//思路：这个解法，真的很棒
//两个链表长度分别为L1+C、L2+C， C为公共部分的长度，按照楼主的做法： 第一个人走了L1+C步后，回到第二个人起点走L2步；第2个人走了L2+C步后，回到第一个人起点走L1步。 当两个人走的步数都为L1+L2+C时就两个家伙就相爱了
//https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/316208