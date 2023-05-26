package leetcode.jianzhiOffer;

import java.awt.*;

public class T5 {
    public static void main(String[] args) {
        T5 t5 = new T5();
        t5.longestPalindrome("cbbd");
    }
    public String longestPalindrome(String s) {
        //遍历每一个或者每两个为中心往两边扩展
        String resStr = "";
        for (int i = 0; i < s.length(); i++) {
            int dif = 0;
            while (i- dif >= 0 && i+dif <= s.length()-1){
                if (s.charAt(i-dif) != s.charAt(i+dif)) break;
                else dif++;
            }
            if (dif*2-1 > resStr.length()){
                resStr = s.substring(i-dif+1,i+dif);
            }
        }

        for (int i = 0; i < s.length()-1; i++) {
            int dif = 0;
            while (i- dif >= 0 && i+1+dif <= s.length()-1){
                if (s.charAt(i-dif) != s.charAt(i+1+dif)) break;
                else dif++;
            }
            if (dif*2 > resStr.length()){
                resStr = s.substring(i-dif+1,i+dif+1);
            }
        }
        return resStr;
    }
}
