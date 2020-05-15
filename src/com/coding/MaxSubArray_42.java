package com.coding;
//42. 连续子数组的最大和
// 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
//要求时间复杂度为O(n)。
//
// 
//
//示例1:
//
//输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//

public class MaxSubArray_42 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int [] dp = new int [len]; //定义为以下标为index的curSum最大（目前最大）
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i: dp){
            max = Math.max(i, max);
        }
        return max;
    }
}
//思路：dp[i]定义为以i为下标时，当前连续的子数组的最大和
//比如示例[-2,1,-3,4,-1,2,1,-5,4]，i=3时，dp[3]=max(dp[2] + nums[3], nums[3]) 我是要之前的和呢？还是抛掉另起炉灶呢？