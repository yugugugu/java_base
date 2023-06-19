package test.leetcode348;

public class T1 {
    public int minimizedStringLength(String s) {
        //就是直接算有多少个不重复的字符
        boolean[] hasCh = new boolean[26];

        for(char ch : s.toCharArray()){
            hasCh[ch-'a'] = true;
        }

        int count = 0;
        for(boolean has :hasCh){
            if (has) count++;
        }
        return count;
    }
}
