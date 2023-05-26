package leetcode;

import java.util.concurrent.CountDownLatch;

class T1114 {

    CountDownLatch a_b = new  CountDownLatch(1);
    CountDownLatch b_c = new  CountDownLatch(1);
    public T1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a_b.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        a_b.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        b_c.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        b_c.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}