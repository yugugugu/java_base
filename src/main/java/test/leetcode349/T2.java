package test.leetcode349;

public class T2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.smallestString("aa");
    }
    public String smallestString(String s) {
        int begin = 0;
        int end = -1;
        while (begin < s.length() && s.charAt(begin) == 'a'){
            begin++;
        }


        for (int i = begin; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                end = i;
                break;
            }
        }
        if (end == -1) end = s.length();
        StringBuffer stringBuffer = new StringBuffer(s);
        for (int i = begin; i < end; i++) {
            stringBuffer.replace(i,i+1,String.valueOf((char) (stringBuffer.charAt(i)-1)));
        }
        if (begin == s.length()){
            stringBuffer.replace(stringBuffer.length()-1,stringBuffer.length(),"z");
        }
        return stringBuffer.toString();
    }
}
