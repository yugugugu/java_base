package juc;

import java.sql.SQLOutput;
import java.util.concurrent.Semaphore;

public class juc_T1 {
    /**
     * 1.三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC…”的字符串
     * https://blog.csdn.net/qq_31960623/article/details/115793981
     * @param args
     */
    public Semaphore a_b = new Semaphore(1);
    public Semaphore b_c = new Semaphore(0);
    public Semaphore c_a = new Semaphore(0);
    private int cnt;
    private volatile  int count = 0;
    public juc_T1(int cnt){
        this.cnt = cnt;
    }

    public static void main(String[] args) {
        juc_T1 resouce = new juc_T1(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        resouce.a_b.acquire();
                        if(resouce.count > resouce.cnt) {
                            break;
                        }
                        System.out.print("A");
//                        System.out.println(Thread.currentThread().getName()+"输出:A");
                        resouce.b_c.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"ThreadA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        resouce.b_c.acquire();
                        if(resouce.count > resouce.cnt) {
                            break;
                        }
                        System.out.print("B");
//                        System.out.println(Thread.currentThread().getName()+"输出:B");
                        resouce.c_a.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"ThreadB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        resouce.c_a.acquire();
                        if(resouce.count > resouce.cnt) {
                            break;
                        }
                        System.out.print("C");
//                        System.out.println(Thread.currentThread().getName()+"输出:C");
                        resouce.count++;
                        resouce.a_b.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"ThreadC").start();
    }
}
