package juc;


import java.util.concurrent.Semaphore;

/**
 * 开启十个线程按序打印1-10
 */
public class juc_0405 {

    private int num = 0;
    private static final Object lock = new Object();

    private void print1_10(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"输出:"+num);
            num++;
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        juc_0405 test = new juc_0405();
        for (int i = 0; i < 10; i++) {
            String name = "Thread_"+i;
            new Thread(new Runnable() {
                public volatile int cnt = 0;

                @Override
                public void run() {
                    test.print1_10();
                }
            },name).start();
        }
    }
}
