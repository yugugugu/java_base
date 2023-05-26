package leetcode.jianzhiOffer;

import java.util.*;

public class T65 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        strings[0] = "me";
        strings[1] = "time";
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        Arrays.stream(strings).forEach((str)->{
            System.out.println(str);
        });
    }
}
