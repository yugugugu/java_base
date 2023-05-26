package leetcode.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

public class T34 {
    public static void main(String[] args) {
        T34 main = new T34();
        main.isAlienSorted(new String[]{"hello", "leetcode"},"hlabcdefgijkmnopqrstuvwxyz");

    }
    public boolean isAlienSorted(String[] words, String order) {
        boolean res = true;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        for(String word : words){
            res = res && isSorted(word,map);
        }
        return res;

    }

    private boolean isSorted(String word, Map<Character, Integer> map) {
        int tem = -1;
        for(char ch : word.toCharArray()){
            if (map.get(ch) >= tem){
                tem = map.get(ch);
            }else {
                return false;
            }
        }
        return true;
    }
}
