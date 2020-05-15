package com.coding;
//45. 把数组排成最小的数
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
// 
//
//示例 1:
//
//输入: [10,2]
//输出: "102"
//示例 2:
//
//输入: [3,30,34,5,9]
//输出: "3033459"

import java.util.Arrays;
import java.util.Comparator;

public class MinNumber_45 {
    public String minNumber(int[] nums) {
        int len = nums.length;
        if(len == 0) return "";
        String [] str = new String [len];
        for(int i = 0; i < len; i++) str[i] = String.valueOf(nums[i]);

        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));  //!!!!!important!!!!!!!
        StringBuffer sb = new StringBuffer();
        for(String s: str) sb.append(s);
        //if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
//思路：好题！重点在于重写Array.sort()的Comparator接口中的compareTo()方法 （现在已经用lambda表达式代替）
//lambda表达式不太熟，还得多练练！！