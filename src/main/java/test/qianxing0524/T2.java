package test.qianxing0524;

import java.util.*;

public class T2 {
    public static Set<String> resset = new HashSet<>();
    public static List<String> resList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Map<Character, String> numToCh = new HashMap<>();
        numToCh.put('1',"abc");
        numToCh.put('2',"def");
        numToCh.put('3',"ghi");
        numToCh.put('4',"jkl");
        numToCh.put('5',"mno");
        numToCh.put('6',"pqr");
        numToCh.put('7',"stu");
        numToCh.put('8',"vwx");
        numToCh.put('9',"yz");

        StringBuilder  stringBuilder = new StringBuilder();
        dfs(input.toCharArray(),0,stringBuilder,numToCh);
        String resstr = "[";
        for (String str: resList){
            resstr += "\'"+ str +"\', ";
        }
        resstr = resstr.substring(0,resstr.length()-2)+"]";
        System.out.println(resstr);
    }

    private static void dfs(char[] toCharArray, int point,StringBuilder stringBuilder,Map<Character, String> numToCh ) {
        if (point == toCharArray.length){
            if (!resset.contains(stringBuilder.toString())){
                resset.add(stringBuilder.toString());
                resList.add(stringBuilder.toString());
            }
            return;
        }

        for(char ch : numToCh.get(toCharArray[point]).toCharArray()){
            stringBuilder.append(ch);
            dfs(toCharArray,point+1,stringBuilder,numToCh);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
