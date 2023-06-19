package test.SF_X0603;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        StringBuffer smallChes  =  new StringBuffer();
        StringBuffer bigChes  =  new StringBuffer();
        StringBuffer nums  =  new StringBuffer();

        for(char ch : str.toCharArray()){
            if (ch-'a'>=0 && ch-'a' < 26){
                smallChes.append(ch);
            }else if(ch-'A'>=0 && ch-'A' < 26){
                bigChes.append(ch);
            }else {
                nums.append(ch);
            }
        }

        System.out.println(smallChes.toString());
        System.out.println(bigChes.toString());
        System.out.println(nums.toString());
    }
}
