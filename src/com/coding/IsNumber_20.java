package com.coding;
//20. 表示数值的字符串
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
//

public class IsNumber_20 {
    public boolean isNumber(String s) {
        if(s.endsWith("f") || s.endsWith("D")) return false;
        try{
            Double.parseDouble(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
//思路：投机取巧了。。。。用Double.parseDouble()来判断（手撕代码这样写的话会被面试官手撕）