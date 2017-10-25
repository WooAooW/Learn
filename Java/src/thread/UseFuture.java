package thread;


import java.util.concurrent.*;

/**
 *
 * Created by liyu on 2017/10/13.
 */
public class UseFuture {

    public static void main(String[] args) {
        future();
    }

    /**
     * 使用Future
     */
    private static void future() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<String> future = service.submit(UseFuture::print);
        try {
            System.out.println("get");
            String result = future.get(3, TimeUnit.SECONDS);
            System.out.println("结果：" + result);
        } catch (TimeoutException e) {
            System.out.println("超时");
            future.cancel(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从1打印到5
     */
    private static String print() {
        try {
            int i = 1;
            while(i++ <= 5) {
                System.out.println(i);
                Thread.sleep(1000);
            }
            return "success";
        } catch (InterruptedException e) {
            return "error";
        }
    }
}
