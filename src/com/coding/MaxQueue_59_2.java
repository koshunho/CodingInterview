package com.coding;
//59 - II. 队列的最大值
// 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//
//若队列为空，pop_front 和 max_value 需要返回 -1
//
//示例 1：
//
//输入:
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
//示例 2：
//
//输入:
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]

import java.util.LinkedList;

public class MaxQueue_59_2 {
    LinkedList<Integer> data;
    LinkedList <Integer> max;
    public MaxQueue_59_2() {
        data = new LinkedList();
        max = new LinkedList();
    }

    public int max_value() {
        if(!max.isEmpty()){
            return max.peekFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        data.add(value);
        while(!max.isEmpty() && value > max.peekLast()){
            max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        if(data.isEmpty()) return -1;
        int num = data.removeFirst();
        if(num == max.peekFirst()){
            max.removeFirst();
        }
        return num;
    }
}
