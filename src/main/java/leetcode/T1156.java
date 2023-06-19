package leetcode;

public class T1156 {
    public static void main(String[] args) {
        T1156 t1156 = new T1156();
        t1156.maxRepOpt1("ababa");

    }
    public int maxRepOpt1(String text) {
        char[] word = text.toCharArray();
        //统计窗口内的各个字符出现的次数
        int[] winCount = new int[26];
        //统计在text中各个字符出现的次数
        int[] charCount = new int[26];
        for(char c:word) charCount[c - 'a']++;
        int maxlen = 1;
        char maxchar = text.charAt(0);
        boolean canChange = true;
        int left = 0,right = 1;
        while(right < text.length()){
            if (text.charAt(right) == text.charAt(right-1)){
                maxchar = text.charAt(right);
                right++;
            }else{
                if (canChange && charCount[maxchar - 'a'] > right - left){
                    right++;
                    canChange = false;
                }else {
                    maxlen = Math.max(maxlen,right-left);
                    canChange = true;
                    left++;
                    while(text.charAt(left) == text.charAt(left-1)){
                        left++;
                    }
                    if (left <right) left++;//left<right表示是aba这种类型的，也就是中间是change了的，需要往前提一位
                    maxchar = text.charAt(right);
                }

            }
        }
        maxlen = Math.max(maxlen,right-left);
        return maxlen;
    }
}
