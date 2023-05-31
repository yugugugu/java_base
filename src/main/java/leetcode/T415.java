package leetcode;

public class T415 {
    public static void main(String[] args) {
        T415 t415 = new T415();
        t415.addStrings("9133","0");

    }
    public String addStrings(String num1, String num2) {
        StringBuffer num1Buffer =  new StringBuffer(num1).reverse();
        StringBuffer num2Buffer =  new StringBuffer(num2).reverse();
        StringBuffer sumBuffer = new StringBuffer();

        boolean isAdd = false;
        int point = 0;
        while(point < Math.min(num1Buffer.length(),num2Buffer.length())){
            int temCh = 0;
            temCh = num1Buffer.charAt(point) + num2Buffer.charAt(point) - 2*'0';
            if (isAdd) temCh += 1;//进位
            isAdd = false;
            if (temCh >= 10){
                isAdd = true;
                temCh -= 10;
            }
            temCh += '0';
            sumBuffer.append((char)temCh);
            point++;
        }

        while (point < num1Buffer.length()){
            int temCh = 0;
            temCh = num1Buffer.charAt(point) - '0';
            if (isAdd) temCh += 1;//进位
            isAdd = false;
            if (temCh >= 10){
                isAdd = true;
                temCh -= 10;
            }
            temCh += '0';
            sumBuffer.append((char)temCh);
            point++;
        }
        while (point < num2Buffer.length()) {
            int temCh = 0;
            temCh = num2Buffer.charAt(point) - '0';
            if (isAdd) temCh += 1;//进位
            isAdd = false;
            if (temCh >= 10){
                isAdd = true;
                temCh -= 10;
            }
            temCh += '0';
            sumBuffer.append((char)temCh);
            point++;
        }

        if (isAdd) sumBuffer.append('1');

        return sumBuffer.reverse().toString();

    }
}
