package com.coding;

import java.util.ArrayList;
import java.util.List;

//62. 圆圈中最后剩下的数字
//
// 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
//
//例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
//
// 
//
//示例 1：
//
//输入: n = 5, m = 3
//输出: 3
//示例 2：
//
//输入: n = 10, m = 17
//输出: 2
//
public class LastRemaining_62 {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        int index = 0;
        while(n > 1){
            index = (index + m - 1) % n; //假设index是当前元素，index + m就是要删除的元素，注意下标要-1. 再取模（当前的长度）
            list.remove(index);
            n--;   //删除一个之后n要-1
        }
        return list.get(0);
    }
}
//思路：约瑟夫环
//之前我都是用一个循环链表来做，但是这样会超市