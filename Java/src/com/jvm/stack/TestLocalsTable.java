package com.jvm.stack;

/**
 * 运行的时候加上参数 -verbose:gc
 * Created by liyu on 07/12/2017.
 */
public class TestLocalsTable {

    /**
     * 局部变量表
     * locals = 4
     *
     * 0 -> args
     * 1 -> big_data
     * 2 -> 1
     * 3 -> b / c 这个被共用了
     */
    public static void main(String[] args) {
        int[] big_data = new int[128 * 1024 * 1024];
        System.out.println(big_data);

        //big_data = null; //如果加上这条，FullGC的时候 会把内存清掉
        System.out.println("before gc");
        System.gc();
        System.out.println("after gc");

        int a = 123;
        {
            int b = 456;
        }
        int c = 789;
    }
}
