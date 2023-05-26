package leetcode.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

public class T14 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1>len2) return false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char ch = s1.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < len1; i++) {
            char ch = s2.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }else {
                map.put(ch,-1);
            }
            if (map.get(ch) == 0) map.remove(ch);
            right++;
        }

        while (!map.isEmpty() && right<len2){
            char leftch = s2.charAt(left);
            char rightch = s2.charAt(right);

            if (map.containsKey(rightch)){
                map.put(rightch,map.get(rightch)-1);
            }else {
                map.put(rightch,-1);
            }
            if (map.get(rightch) == 0) map.remove(rightch);

            if (map.containsKey(leftch)){
                map.put(leftch,map.get(leftch)+1);
            }else {
                map.put(leftch,1);
            }
            if (map.get(leftch) == 0) map.remove(leftch);

            left++;
            right++;
        }

        if (map.isEmpty()) return true;
        else return false;
    }
}
