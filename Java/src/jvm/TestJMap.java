package jvm;

import bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liyu on 2017/5/24.
 */
public class TestJMap {

    private static List<User> cache;
    private static List<User> permCache;

    static {
        permCache = new ArrayList<>();
        for(int i = 0; i < 2000000; i++){
            User user = new User();
            user.setId(i);
            permCache.add(user);
        }
        System.out.println("init data");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                cache = new ArrayList<User>();
                //200000 is ok, while 400000 is bad.
                for(int i = 0; i < 400000; i++){
                    User user = new User();
                    user.setId(i);
                    cache.add(user);
                }
                System.out.println("refresh data");
            }
        }, 1000, 100);
    }

    //-XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:+ScavengeBeforeFullGC -XX:+UseParNewGC -Xms256M -Xmx256M -Xmn152M -XX:CMSInitiatingOccupancyFraction=60 -XX:SurvivorRatio=22
    public static void main(String[] args){

        System.out.println("Start");
        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stop");
    }
}
