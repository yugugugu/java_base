package leetcode.jianzhiOffer;

public class T20 {
    public int count = 0;
    public int countSubstrings(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len ; j++) {
                if (ishuiwen(s.substring(i,j))) count ++;
            }
        }
        return count;
    }

    private boolean ishuiwen(String subS) {
        int left = 0, right = subS.length()-1;
        while (left < right){
            if (subS.charAt(left) != subS.charAt(right)) return  false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
