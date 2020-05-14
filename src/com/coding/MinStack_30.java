package com.coding;
//30. 包含min函数的栈
// 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
// 
//
//示例:
//
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.

import java.util.Stack;

public class MinStack_30 {
    Stack <Integer> data;
    Stack<Integer> minValue;
    /** initialize your data structure here. */
    public MinStack_30() {
        data = new Stack();
        minValue = new Stack();
    }

    public void push(int x) {
        data.push(x);
        if(minValue.isEmpty() || minValue.peek() >= x){
            minValue.push(x);
        }
    }

    public void pop() {
        int num = data.pop();
        if(num == minValue.peek()){
            minValue.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minValue.peek();
    }
}
//思路：用两个栈。A栈正常存，B栈存当前【区间】的最小值，每次A栈弹出元素时，都判断和B栈栈顶元素是否相等，相等则一起弹出