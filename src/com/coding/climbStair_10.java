package com.coding;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class climbStair_10 {
    public int climbStair(int number){
        if(number <= 0){
            return 0;
        }
        else
            return (int) Math.pow(2, number-1);
    }
}
//思路：n个台阶会有一次n阶的跳法
//f(n)= f(n-1) + f(n-2) + f(n-3) +... + f(n-(n-1)) + f(n-n)
//简化
//f(n-1) = f(0) + f(1) + f(2) + f(3) +...+ f((n-1)-1) = f(0) + f(1) + f(2) +f(3) + ...+f(n-2)
//
//两式想减，可以得出：
//f(n) = 2 * f(n-1)
//可知这是一个等比数列：[1,2,4,8,...,2^(n-1)]
