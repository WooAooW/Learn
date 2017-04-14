import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序.
 * 核心思想: 分而治之,小的放左边,大的放右边.
 * 
 * @see https://heleeos.com/blog/sorting-algorithm-theory.html#7快速排序
 * @author liyu
 */
public class QuickSort {

    //递归的次数
    public static int recursiveCount = 1;
    
    public static void main(String[] args) {
        List<Integer> data = getData(20);
        data.forEach(num -> System.out.printf("%s,", num));
        System.out.println();
        quickSortRecursive(data, 0, data.size() - 1);                
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
    
    /**
     * 交换两个元素
     **/
    public static void swap(List<Integer> data, int index1, int index2) {
        int temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, temp);
    }
    
    /**
     * 递归实现快速排序.
     * 
     * @param start 开始下标
     * @param end   结束下标
     */
    public static void quickSortRecursive(List<Integer> data, int start, int end) {
        if(start >= end) 
            return;
        int number = data.get(end);
        int left = start;
        int right = end;
        while(left < right) {
            while(data.get(left) < number && left < right) {
                left++;
            }
            while(data.get(right) > number && left < right) {
                right--;
            }
            swap(data, left, right);
        }
        System.out.printf("第 %s 次:", recursiveCount++);
        data.forEach(num -> System.out.printf("%s ", num));
        System.out.println();
        quickSortRecursive(data, start, left - 1);
        quickSortRecursive(data, left + 1, end);
    }
}
