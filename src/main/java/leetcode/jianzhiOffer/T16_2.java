package leetcode.jianzhiOffer;

public class T16_2 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        boolean[] arr  = new boolean[128];
        int left = 0;
        int right = 0;

        int maxlen = right - left;
        while (right < s.length()){
            if (!arr[s.charAt(right)]){
                arr[s.charAt(right)] = true;
                right++;
                maxlen = Math.max(maxlen,right-left);
            }else {
                while (left < right){
                    if (s.charAt(left) == s.charAt(right)){
                        arr[s.charAt(left)] = false;
                        left++;
                        break;
                    }else{
                        arr[s.charAt(left)] = false;
                        left++;
                    }
                }
            }
        }
        return  maxlen;
    }
}
