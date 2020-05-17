package com.coding;
//66. 构建乘积数组
// 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//
// 
//
//示例:
//
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24]
//
public class ConstructArr_66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int [] left = new int [len];
        int [] right = new int [len];
        int [] ans = new int [len];
        int k = 1;   //关键
        for(int i = 0; i < len; i++){
            left[i] = k;
            k *= a[i];
        }
        k = 1;    //关键
        for(int i = len - 1; i >= 0; i--){
            right[i] = k;
            k *= a[i];
        }
        for(int i = 0; i < len; i++) ans[i] = left[i] * right[i];
        return ans;
    }
}
//思路：对称遍历