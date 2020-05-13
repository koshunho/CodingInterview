package com.coding;
//17. 打印从1到最大的n位数
// 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
//示例 1:
//
//输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
//说明：
//
//用返回一个整数列表来代替打印
//n 为正整数
//

public class PrintNumbers_17 {
    public int[] printNumbers(int n) {
        StringBuffer sb = new StringBuffer();
        while(n > 0){
            sb.append("9");
            n--;
        }
        int max = Integer.parseInt(sb.toString());
        int [] ans = new int [max];
        for(int i = 0; i < max; i++) ans[i] = i+1;
        return ans;
    }
}
//思路：用字符串找到最大的数字，比如n=5,5位整数的话那么最大值就是99999，这就是数组的大小
// （没测试过大数，如果n太大应该就做不了了，不过题目要求返回一个int数组，看来测试用例也不是很大（面向测试用例编程笑））