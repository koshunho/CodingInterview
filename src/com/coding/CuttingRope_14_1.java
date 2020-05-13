package com.coding;
//14.1 剪绳子
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
//示例 1：
//
//输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//示例 2:
//
//输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//

public class CuttingRope_14_1 {
    public int cuttingRope(int n) {
        int [] dp = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
//思路：个人觉得剑指中比较难的题了，直接抄的答案
//动态转移方程式：dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]))
//dp[i]表示绳子长度为i时，它剪成的每段绳子的乘积的最大值
//dp[i]:表示不剪，维持原状态
//j * (i-j):从j处剪一下，剪下来的部分是(i-j)， i-j不再剪了
//j * dp[i - j]：从j处剪一下，剪下来的部分是(i-j)， i-j继续剪
