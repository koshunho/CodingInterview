package com.coding;
//21. 调整数组顺序使奇数位于偶数前面
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//
// 
//
//示例：
//
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。
//
public class Exchange_21 {
    public int[] exchange(int[] nums) {
        for(int i = 0, j = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                swap(i, j++, nums);
            }
        }
        return nums;
    }
    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//思路：双指针,龟兔赛跑。
// i,j 同时从0出发，i开始指向奇数，j指向 当前排好的最后一个奇数 or 第一个偶数（可能表述不太正确，用示例带进去就明白了