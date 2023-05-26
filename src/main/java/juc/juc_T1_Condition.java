package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class juc_T1_Condition {
    private Lock lock = new ReentrantLock();
    private Condition a_b = lock.newCondition();
    private Condition b_c = lock.newCondition();
    private Condition c_a = lock.newCondition();
    private  int n;
    public  juc_T1_Condition(int n){
        this.n = n;
    }

    public static void main(String[] args) throws InterruptedException {
        juc_T1_Condition resouce = new juc_T1_Condition(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                resouce.lock.lock();
                for (int i = 0; i < resouce.n; i++) {
                    try {
                        resouce.a_b.await();
                        System.out.println(Thread.currentThread().getName()+":A");
                        resouce.b_c.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                resouce.lock.unlock();

            }
        },"ThreadA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                resouce.lock.lock();
                for (int i = 0; i < resouce.n; i++) {
                    try {
                        resouce.b_c.await();
                        System.out.println(Thread.currentThread().getName()+":B");
                        resouce.c_a.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                resouce.lock.unlock();

            }
        },"ThreadB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                resouce.lock.lock();
                for (int i = 0; i < resouce.n; i++) {
                    try {
                        resouce.c_a.await();
                        System.out.println(Thread.currentThread().getName()+":C");
                        resouce.a_b.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                resouce.lock.unlock();

            }
        },"ThreadC").start();

        Thread.sleep(1000);
        resouce.lock.lock();
        resouce.a_b.signal();
        resouce.lock.unlock();
    }
}
