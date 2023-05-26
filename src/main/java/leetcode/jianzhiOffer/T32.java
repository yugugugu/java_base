package leetcode.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

public class T32 {
    public static void main(String[] args) {
        isAnagram("a","a");
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }

        for(char ch : t.toCharArray()){
            if (!map.containsKey(ch)) return false;
            else {
                map.put(ch,map.get(ch)-1);
                if (map.get(ch) == 0) map.remove(ch);
            }
        }

        return map.isEmpty();
    }
}
