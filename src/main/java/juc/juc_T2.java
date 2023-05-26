package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class juc_T2 {
    /**
     * 2.两个线程交替打印 0~100 的奇偶数
     * @param args
     */
    public volatile int count = 0;
    Lock lock = new  ReentrantLock();
    public int state = 0;

    public void printNums(int state){
        while (count < 100){
            lock.lock();
            if (this.state == state){
                System.out.println(Thread.currentThread().getName()+"输出:"+count);
                count ++;
                this.state = state==1?0:1;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        juc_T2 resouce = new juc_T2();
        new  Thread(new Runnable() {
            @Override
            public void run() {
                resouce.printNums(1);
            }
        },"odd").start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                resouce.printNums(0);
            }
        },"even").start();
    }
}
