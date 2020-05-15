package com.coding;
//50. 第一个只出现一次的字符
// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
//示例:
//
//s = "abaccdeff"
//返回 "b"
//
//s = ""
//返回 " "
//
public class FirstUniqChar_50 {
    public char firstUniqChar(String s) {
        int [] dict = new int [26];
        for(int i = 0; i < s.length(); i++) dict[s.charAt(i) - 'a']++;
        for(int i = 0; i < s.length(); i++){
            if(dict[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }
}
//思路：用一个长度为26的数组来记录某个字母出现的次数（当然前提是全是大写字母 or 小写字母
//这个做法比用HashMap <Character, Integer>记录快