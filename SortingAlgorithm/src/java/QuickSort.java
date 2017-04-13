import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序.
 * 核心思想: .
 * 
 * @see https://heleeos.com/blog/sorting-algorithm-theory.html#7快速排序
 * @author liyu
 */
public class QuickSort {

    public static void main(String[] args) {
        List<Integer> data = getData(20);
        data.forEach(num -> System.out.printf("%s,", num));
        System.out.println();
        
                
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
