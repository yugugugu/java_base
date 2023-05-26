package juc;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class juc_timerTask {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };

        System.out.println("当前时间: " + new Date() + "n" +
                "线程名称: " + Thread.currentThread().getName());

        Timer timer = new Timer("timer");
        long delay = 1000L;
        timer.schedule(task,delay);
    }
}
