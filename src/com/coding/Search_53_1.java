package com.coding;
//53 - I. 在排序数组中查找数字 I
//统计一个数字在排序数组中出现的次数。
//
// 
//
//示例 1:
//
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//示例 2:
//
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
//
public class Search_53_1 {
    public int search(int[] nums, int target) {
        int left = leftBound(nums, target);
        if(left == -1) return 0;
        int right = rightBound(nums, target);
        return right - left + 1;
    }
    int leftBound(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2; //收紧右边界以锁定左边界
            if(nums[mid] == target) right = mid;
            else if(nums[mid] > target) right = mid;
            else if(nums[mid] < target) left = mid + 1;
        }
        if(right == nums.length) return -1;
        return nums[right] == target ? right : -1;
    }
    int rightBound(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) left = mid + 1; //收紧左边界以锁定右边界
            else if(nums[mid] > target) right = mid;
            else if(nums[mid] < target) left = mid + 1;
        }
        if(left == 0) return -1;
        return nums[left-1] == target ? left - 1: -1;
    }
}
//思路：二分的综合运用（这道题的热评第一是我写的~~~~~~~面试官出这题的话肯定是想让你写二分的啦 其他没用
//关于二分，可以看labuladong大佬写的文章，非常详细