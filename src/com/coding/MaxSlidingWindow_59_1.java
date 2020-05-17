package com.coding;
//59 - I. 滑动窗口的最大值
// 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
//示例:
//
//输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
//提示：
//
//你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxSlidingWindow_59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> index = new LinkedList();
        List<Integer> list = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            while(!index.isEmpty() && nums[i] > nums[index.peekLast()]){
                index.removeLast();
            }
            index.addLast(i);
            if(index.peekFirst() <= i-k){
                index.removeFirst();
            }
            if(i >= k-1){
                list.add(nums[index.peekFirst()]);
            }
        }
        int [] ans = new int [list.size()];
        for(int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
    Proxy
}
//思路：维护一个单调队列