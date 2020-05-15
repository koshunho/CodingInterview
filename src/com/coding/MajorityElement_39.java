package com.coding;
//39. 数组中出现次数超过一半的数字
// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
// 
//
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 
//
//示例 1:
//
//输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2

public class MajorityElement_39 {
    public int majorityElement(int[] nums) {
        Integer key = null;
        int count = 0;
        for(int i: nums){
            if(count == 0){
                key = i;
            }
            count += (key == i)? 1 : -1;
        }
        return key;
    }
}
//思路：同归于尽