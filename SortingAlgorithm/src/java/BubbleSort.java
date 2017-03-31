import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 冒泡排序.
 * 核心思想: 数字大的往后靠.
 */
public class BubbleSort {

    public static void main(String[] args) {
        List<Integer> data = getData(20);
        data.forEach(num -> System.out.printf("%s,", num));
        System.out.println();
        
        int size = data.size();
        for(int i = 0; i < size; i++) {
            boolean change = false;
            int maxIndex = size - i - 1;
            for(int index = 0; index < maxIndex; index++) {
                int a = data.get(index);
                int b = data.get(index + 1);
                if(a > b) {
                    data.set(index, b);
                    data.set(index + 1, a);
                    change = true;
                }
            }
            System.out.printf("第 %s 次:", i + 1);
            data.forEach(num -> System.out.printf("%s ", num));
            System.out.println();
            if(change == false) {
                break;
            }
        }
        
        data.forEach(num -> System.out.printf("%s,", num));
    }
    
    /**
     * 生成一组数据
     */
    public static List<Integer> getData(int n) {
        List<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            list.add(i, i);
        Collections.shuffle(list);//打乱顺序
        return list;
    }
}
