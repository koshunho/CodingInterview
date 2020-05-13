package com.coding;
//14-2 剪绳子 ‖
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
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


public class CuttingRope_14_2 {
    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;

        long ans = 1; //注意是long
        while(n > 4){
            ans *= 3;
            ans %= 1000000007;
            n -= 3;
        }
        return (int)(ans * n % 1000000007);
    }
}
//思路：涉及数学推导。数学极度苦手 就不班门弄斧了
//大佬的推导：https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/