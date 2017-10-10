package sdk;

/**
 *
 * Created by liyu on 2017/10/10.
 */
public class Test2 {

    public static int add(int a, int b) {
        return a + b;
    }

    private static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    private static int getMin(int a, int b) {
        if(a < b) {
            return a;
        } else {
            return b;
        }
    }
}
