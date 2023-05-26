package leetcode;

import java.util.concurrent.Semaphore;

class T1145 {
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(1);

    public T1145(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            bar.release();
        }
    }
}