import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 希尔排序.
 * 核心思想: 分组进行插入排序.
 * 
 * @see https://heleeos.com/blog/sorting-algorithm-theory.html#4希尔排序
 * @author liyu
 */
public class ShellSort {

    public static void main(String[] args) {
        List<Integer> data = getData(20);
        System.err.println("数据:" + data);
        shellSort(data);
        System.err.println("结果:" + data);
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
    
    /**
     * 希尔排序
     */
    public static void shellSort(List<Integer> data) {
        int size = data.size();
        for(int gap = size >> 1; gap > 0; gap = gap >> 1) {
            
            //对每一个元素进行插入排序
            for(int i = gap; i < size; i++) {
                int temp = data.get(i);
                int j;
                for(j = i - gap; j >= 0; j -= gap) {
                    if(temp < data.get(j)) {
                        data.set(j + gap, data.get(j));
                    } else {
                        break;
                    }
                }
                data.set(j + gap, temp);
            }
            
            System.out.printf("步长为:%s,", gap);
            data.forEach(num -> System.out.printf("%s ", num));
            System.out.println();
        }
    }
}
