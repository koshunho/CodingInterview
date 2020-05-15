package com.coding;

import java.util.HashMap;

//48. 最长不含重复字符的子字符串
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//
// 
//
//示例 1:
//
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
public class LengthOfLongestSubstring_48 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap();
        int left = 0, right = 0, ans = 0;
        while(right < s.length()){
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);

            while(window.get(s.charAt(right)) > 1){
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
//思路：超经典滑动窗口。这道题开启了我的滑窗大门（笑哭
