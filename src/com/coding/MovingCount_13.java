package com.coding;
//13.机器人的运动范围
// 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
// 
//
//示例 1：
//
//输入：m = 2, n = 3, k = 1
//输出：3
//示例 2：
//
//输入：m = 3, n = 1, k = 0
//输出：1
//
public class MovingCount_13 {
    class Solution {
        int [] upDown = new int [] {-1, 0, 1, 0};
        int [] leftRight = new int [] {0, 1, 0, -1};
        int count = 0;
        public int movingCount(int m, int n, int k) {
            boolean [][] used = new boolean [m][n];
            backtrack(0, 0, m, n, k, used);
            return count;
        }
        void backtrack(int i, int j, int m, int n, int k, boolean [][] used){
            if(i < 0 || i >= m || j < 0 || j >= n || used[i][j]) return;

            if(!meet(i, j, k)) return;

            used[i][j] = true;

            count++;

            for(int x = 0; x < 4; x++) backtrack(i + upDown[x], j + leftRight[x], m, n, k, used);
        }
        boolean meet(int i, int j, int k){
            String s1 = String.valueOf(i);
            String s2 = String.valueOf(j);
            int sum1 = 0, sum2 = 0;
            for(int x = 0; x < s1.length(); x++) sum1 += Integer.parseInt(s1.charAt(x) + "");
            for(int x = 0; x < s2.length(); x++) sum2 += Integer.parseInt(s2.charAt(x) + "");
            return sum1 + sum2 <= k;
        }
    }
}
//思路：还是回溯
//用一个used数组记录走过的空格，避免反复横跳。meet()判断是否满足下标和是否满足条件。