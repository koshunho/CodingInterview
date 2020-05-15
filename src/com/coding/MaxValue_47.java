package com.coding;
//47. 礼物的最大价值
//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//
// 
//
//示例 1:
//
//输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//

public class MaxValue_47 {
    public int maxValue(int[][] grid) {
        int col = grid.length, row = grid[0].length;
        int [][] max = new int [col][row];
        max[0][0] = grid[0][0];

        for(int i = 1; i < col; i++){
            max[i][0] = grid[i][0] + max[i-1][0];
        }
        for(int i = 1; i < row; i++){
            max[0][i] = grid[0][i] + max[0][i-1];
        }

        for(int i = 1; i < col; i++){
            for(int j = 1; j < row; j++){
                max[i][j] = Math.max(max[i-1][j], max[i][j-1]) + grid[i][j];
            }
        }
        return max[col-1][row-1];
    }
}
//思路：为数不多能看一眼就能写出来的dp（笑哭）
//先确定第一行第一列的值（初始状态），然后就可以继续做了