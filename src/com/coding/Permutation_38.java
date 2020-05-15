package com.coding;
//输入一个字符串，打印出该字符串中字符的所有排列。
//
// 
//
//你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
// 
//
//示例:
//
//输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation_38 {
    public String[] permutation(String s) {
        List<String> ans = new ArrayList();
        boolean [] used = new boolean [s.length()];
        helper(s, ans, new StringBuffer(), used);
        HashSet<String> hs = new HashSet(ans);
        ans.clear();
        for(String str: hs) ans.add(str);
        String [] res = new String [ans.size()];
        for(int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }
    void helper(String s, List <String> ans, StringBuffer sb, boolean [] used){
        if(sb.length() == s.length()){
            ans.add(new StringBuffer(sb).toString());
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(used[i]) continue;
            used[i] = true;
            sb.append(s.charAt(i));
            helper(s, ans, sb, used);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//思路：（不是优解！！自己写得比较混乱
//本质还是回溯，重点是如何去重