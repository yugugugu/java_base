package base;

public class mianxiangduixiang {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        mianxiangduixiang ex = new mianxiangduixiang();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
        //测试冲突
        Boolean.valueOf(true);
    }
}