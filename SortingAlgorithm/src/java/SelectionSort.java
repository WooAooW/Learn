import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 选择排序.
 * 核心思想: 将最小的数字替换到前面.
 * 
 * @see https://heleeos.com/blog/sorting-algorithm-theory.html#2选择排序
 * @author liyu
 */
public class SelectionSort {

    public static void main(String[] args) {
        List<Integer> data = getData(20);
        System.err.println("数据:" + data);
        selectionSort(data);     
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
     * 选择排序
     */
    public static void selectionSort(List<Integer> data) {
        int size = data.size();
        for(int i = 0; i < size; i++) {
            int min = data.get(i);
            int changeIndex = i;
            
            //找出未排序元素中最小的数字的下标
            for(int index = i + 1; index < size; index++) {
               int thisNumber = data.get(index);
               if(min > thisNumber) {
                   min = thisNumber;
                   changeIndex = index;
               }
            }
            
            //交换未排序元素中最小数字和第一个数字
            if(changeIndex != i) {
                int temp = data.get(i);
                data.set(i, min);
                data.set(changeIndex, temp);
            }
            
            System.out.printf("第 %s 次:", i + 1);
            data.forEach(num -> System.out.printf("%s ", num));
            System.out.println();
        }
    }
}
