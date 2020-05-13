package com.coding;
//用两个栈实现一个队列。
// 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
// (若队列中没有元素，deleteHead 操作返回 -1 )
//
// 
//
//示例 1：
//
//输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//示例 2：
//
//输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//

import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
public class CQueue_09 {
    Stack<Integer> data;
    Stack <Integer> temp;
    public CQueue_09() {
        data = new Stack();
        temp = new Stack();
    }

    public void appendTail(int value) {
        data.push(value);
    }

    public int deleteHead() {
        if(data.isEmpty()) return -1;
        while(data.size() > 1){
            temp.push(data.pop());
        }
        int num = data.pop();
        while(!temp.isEmpty()){
            data.push(temp.pop());
        }
        return num;
    }
}
//思路：A栈正常存，B栈在A栈需要删除头的时候使用，临时存储要删除的元素之前的元素。