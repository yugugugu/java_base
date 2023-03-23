package juc;

import java.util.concurrent.*;

public class executorTest {

    public static ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10,
            100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
    public static Executor tpe2 = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = tpe.submit(new callableTest());
        System.out.println(future.get());
        Future future2 = tpe.submit(new runableTest());
        future2.cancel(true);

    }
}

class runableTest implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String a = "return String";
        System.out.println("runableTest");
    }
}
class callableTest implements Callable<String > {
    @Override
    public String call() {
        try{
            String a = "return String";
            return a;
        }
        catch(Exception e){
            e.printStackTrace();
            return "exception";
        }
    }
}