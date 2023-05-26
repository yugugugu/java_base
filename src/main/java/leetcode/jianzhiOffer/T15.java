package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T15 {
    public static void main(String[] args) {
        findAnagrams("cbaebabacd","abc");
    }
    public static List<Integer> findAnagrams(String s, String p) {
        String s1 = p;
        String s2 = s;
        int len1 = s1.length();
        int len2 = s2.length();

        List<Integer> res = new ArrayList<>();

        if(len1>len2) return res;
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

        while (right<len2){
            if (map.isEmpty()) res.add(left);
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
        if (map.isEmpty()) res.add(left);
        return res;
    }
}
