package sdk.javap;

/**
 * 包含以下内容:
 * 1.while 循环
 * 2.for 循环
 * 3.构造实例
 *
 * java -v Test4
 * Created by liyu on 2017/10/10.
 */
public class Test4 {

    protected void add_100_while() {
        int sum = 0;
        int i = 1;
        while(i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("1 + ... + 100 = " + sum);
    }

    void add_100_for() {
        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.println("1 + ... + 100 = " + sum);
    }

    public static void main(String[] args) {
        Test4 test = new Test4();
        test.add_100_for();
        test.add_100_while();
    }
}
