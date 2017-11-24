package thread;

import java.util.concurrent.Callable;

/**
 * Created by liyu on 2017/10/13.
 */
public class Test2 implements Runnable {
    
    public static void main(String[] args) {
        Callable<Object> callable = new Callable<Object>() {
            public Object call() throws Exception {
                return null;
            }
        };
        System.out.println("sysout");


    }

    @Override
    public void run() {

    }
}
