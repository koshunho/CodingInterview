package com.coding;
//49. 丑数
// 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
// 
//
//示例:
//
//输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//说明:  
//
//1 是丑数。
//n 不超过1690。

public class NthUglyNumber_49 {
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int [] dp = new int [n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if(dp[i] == dp[i2] * 2) i2++;
            if(dp[i] == dp[i3] * 3) i3++;
            if(dp[i] == dp[i5] * 5) i5++;
        }
        return dp[n-1];
    }
}
//思路：三指针。方法很巧妙 有点tricky了 没看答案想不出