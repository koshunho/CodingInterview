package com.coding;

import java.util.ArrayList;
import java.util.List;

//57 - II. 和为s的连续正数序列
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
//        序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//
//
//        示例 1：
//
//        输入：target = 9
//        输出：[[2,3,4],[4,5]]
//        示例 2：
//
//        输入：target = 15
//        输出：[[1,2,3,4,5],[4,5,6],[7,8]]
public class FindContinuousSequence_57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList();
        int left = 1, right = 2, curSum = left+right;
        while(right < target){
            if(curSum == target){
                int len = right-left+1;
                int [] cur = new int [len];
                int j = left;
                for(int i = 0; i < len; i++){
                    cur[i] = j;
                    j++;
                }
                list.add(cur);
                right++;
                curSum += right;  //找到后务必记得移动窗口!!!增大或缩小都可以!!!!!!!!!
            }
            else if(curSum > target){
                curSum -= left;    //left要先减掉!!!!!
                left++;
            }
            else if(curSum < target){
                right++;            //right要先自增!!!!!!
                curSum += right;
            }
        }
        int [][] ans = new int [list.size()][];
        return list.toArray(ans);
    }
}
//思路：嘻嘻 这道题热评第一又是我 100+赞（为什么一定要用二维数组做返回值）
//有三处用注解标识的地方，务必需要注意