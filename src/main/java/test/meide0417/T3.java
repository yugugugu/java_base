package test.meide0417;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int countM = 0;
        int countP = 0;//保存连续p的数量
        int score = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='P'){
                countP++;
                if(countP > 3) score+=15;
                else score+=10;
            }else if (str.charAt(i)=='G'){
                score += 5;
                countP = 0;
            }else{
                countP = 0;
                countM++;
                if (countM == 3) break;
            }
        }
        System.out.println(score);
    }
}
