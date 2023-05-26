package leetcode.jianzhiOffer;

public class T19 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("deeee"));
    }
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                    if (ishuiwen(s.substring(left,right)) || ishuiwen(s.substring(left+1,right+1))){
                        return true;
                    }else {
                        return false;
                    }
            }
            left++;
            right--;
        }
        return  true;
    }

    public static boolean ishuiwen(String s){
        int left = 0;
        int right = s.length()-1;
        boolean isdel = false;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
