package leetcode.jianzhiOffer;

public class T18 {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }
    public static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for(Character ch:s1.toCharArray()){
            if ((ch >= 'a' && ch <= 'z' )|| (ch >= '0' && ch <= '9') ){
                stringBuilder.append(ch);
            }
        }
        s1 = stringBuilder.toString();
        int left = 0;
        int right = s1.length()-1;
        while (left <= right){
            if (s1.charAt(left) != s1.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
