package leetcode;

import com.sun.xml.internal.ws.util.StringUtils;

public class T43 {

    static {

    }
    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        int add =0;//表示进位
        int mod = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder strnum1 = new StringBuilder(num1);
        StringBuilder strnum2 = new StringBuilder(num2);
        for(int i=0; i < strnum1.length();i++){
            int mul1 = strnum1.charAt(strnum1.length()-1-i)-'0';
            if(mul1==0) continue;
            for(int j=0;j<strnum2.length();j++){
                int mul2 = strnum2.charAt(strnum2.length()-1-j)-'0';
                int product = mul1*mul2+add;
                if(i+j+1 <= res.length()){
                    product += (res.charAt(i+j)-'0');
                }
                add = product/10;
                mod =product%10;
                if(i+j+1 <= res.length()){
                    res.replace(i+j,i+j+1,String.valueOf((char)(mod+'0')));
                }else{
                    res.append((char)(mod+'0'));
                }
                mod =0;
            }
            //需要把进位加进去
            if(add!=0){
                res.append((char)(add+'0'));
            }
            System.out.println(res.toString());
            add=0;
        }
        System.out.println(res.reverse().toString());
    }
}
