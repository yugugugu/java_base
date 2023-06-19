package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class futureTest {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });

    }
}
