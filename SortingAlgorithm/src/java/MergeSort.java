import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 归并排序.
 * 核心思想: 分成N个序列, 依次进行归并操作.
 * 
 * @see https://heleeos.com/blog/sorting-algorithm-theory.html#6归并排序
 * @author liyu
 */
public class MergeSort {

    public static void main(String[] args) {
        List<Integer> data = getData(20);
        System.out.println("数据:" + data);
        List<Integer> result = mergeSortRecursive(data, 0, data.size() - 1);
        System.out.println("结果:" + result);
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
     * 递归实现归并排序.
     */
    public static List<Integer> mergeSortRecursive(List<Integer> data, int start, int end) {
        List<Integer> result = new ArrayList<>(end - start + 1);
        
        //一个元素
        if(start >= end) {
            result.add(data.get(start));
            return result;
        }
        
        int mid = (start + end) / 2;
        
        List<Integer> result1 = mergeSortRecursive(data, start, mid);
        List<Integer> result2 = mergeSortRecursive(data, mid + 1, end);
        
        //进行归并, 2个合成1个
        int size1 = result1.size();
        int size2 = result2.size();
        int i = 0, j =0;
        while(i < size1 && j < size2) {
            Integer num1 = result1.get(i);
            Integer num2 = result2.get(j);
            if(num1 < num2) {
                result.add(num1);
                i++;
            } else {
                result.add(num2);
                j++;
            }
        }
        
        while(i < size1) {
            result.add(result1.get(i++));
        }
        
        while(j < size2) {
            result.add(result2.get(j++));
        }
        
        System.out.println(String.format("%s, %s 归并为 %s", result1, result2, result));
        
        return result;
    }
}
