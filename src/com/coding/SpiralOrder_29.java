package com.coding;

import java.util.ArrayList;
import java.util.List;

//29. 顺时针打印矩阵
// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
// 
//
//示例 1：
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//示例 2：
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
public class SpiralOrder_29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int [0];
        int l = 0, t = 0, r = matrix[0].length-1, b = matrix.length-1;
        List<Integer> list = new ArrayList();
        while(true){
            for(int i = l; i <= r; i++) list.add(matrix[t][i]);
            if(++t > b) break;
            for(int i = t; i <= b; i++) list.add(matrix[i][r]);
            if(--r < l) break;
            for(int i = r; i >= l; i--) list.add(matrix[b][i]);
            if(--b < t) break;
            for(int i = b; i >= t; i--) list.add(matrix[i][l]);
            if(++l > r) break;
        }
        int [] ans = new int [list.size()];
        for(int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
}
//思路：这道题看着简单，其实要想一次性写对是不容易的，边界情况很多，不留神就非常容易出错
//非常推荐的一个分析：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/