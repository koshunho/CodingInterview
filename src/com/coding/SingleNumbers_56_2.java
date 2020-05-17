package com.coding;
//56 - II. 数组中数字出现的次数 II
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
// 
//
//示例 1：
//
//输入：nums = [3,4,3,3]
//输出：4
//示例 2：
//
//输入：nums = [9,1,7,9,7,9,7]
//输出：1
//
public class SingleNumbers_56_2 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(((nums[j] >> i) & 1) == 1) count++;
            }
            if(count % 3 != 0) ans = ans | (1 << i);
        }
        return ans;
    }
}
//思路：【考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数】
// 考虑32位数，遍历每一位，再对每个数的这一位进行统计。如果不是3的倍数的话，就保存答案的这一位起来