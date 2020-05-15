package com.coding;
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
//
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]


import java.util.HashMap;

public class CopyRandomList_35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap();
        Node node = head;
        while(node != null){
            hm.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while(node != null){
            hm.get(node).next = hm.get(node.next);
            hm.get(node).random = hm.get(node.random);
            node = node.next;
        }
        return hm.get(head);
    }
}
//思路：即实现这个链表的深拷贝
//浅拷贝只复制指向某个对象的指针，而不复制对象本身，新旧对象还是共享同一块内存。
//但深拷贝会另外创造一个一模一样的对象，新对象跟原对象不共享内存，修改新对象不会改到原对象。
