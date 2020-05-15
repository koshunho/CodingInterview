package com.coding;
//46. 把数字翻译成字符串
// 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
// 
//
//示例 1:
//
//输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//

public class TranslateNum_46 {
    public int translateNum(int num) {
        char [] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        if(len == 0) return 0;
        int [] dp = new int [len+1];  //注意，dp代表 字符串长度 长度 长度。
        dp[0] = 1;
        for(int i = 1; i <= len; i++){   //注意dp代表 字符串长度 长度 长度
            dp[i] += dp[i-1];
            if(i > 1){
                int combination = (arr[i-2] - '0') * 10 + (arr[i-1] - '0');
                if(combination >= 10 && combination <= 25){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[len];
    }
}
//思路：初始dp[0]=1
//dp[1] = 1? 空串也有一种翻译方式->其实初始状态有时还挺费解的
//具体分析可以看：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
