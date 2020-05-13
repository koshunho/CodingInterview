package com.coding;
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//
// 
//
//示例:
//
//现有矩阵 matrix 如下：
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//给定 target = 5，返回 true。
//
//给定 target = 20，返回 false。

public class findNumberIn2DArray_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int column = matrix[0].length - 1, row = 0;   //从右上角开始扫描
        while(column >= 0 && row < matrix.length){
            if(matrix[row][column] == target) return true;
            else if(matrix[row][column] > target){
                column--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}
//思路：感觉有点tricky，没看答案前确实没什么思路，就暴力。
//官方题解中的解释：
//从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
// 如果当前元素大于目标值，则移到左边一列。
// 如果当前元素小于目标值，则移到下边一行。
//
//可以证明这种方法不会错过目标值。
// 如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，往左查找可能找到目标值。
// 如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。

