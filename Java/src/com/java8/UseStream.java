package com.java8;

import com.common.bean.DishItem;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 *
 * Created by liyu on 29/12/2017.
 */
public class UseStream {

    public static void stream1(List<DishItem> dishItemList) {
        dishItemList.stream()
                    .filter(new Predicate<DishItem>() {
                        @Override
                        public boolean test(DishItem dishItem) {

                                boolean flag = dishItem.isCanDisc();
                                return flag;

                            }
                        }
                    )

                
                    .filter(dishItem -> {
                        boolean flag = dishItem.isCanDisc();
                        return flag;
                    })


                    .filter(dishItem -> dishItem.isCanDisc())


                    .filter(DishItem::isCanDisc)






            /** 过滤打折 */
                    .collect(toList());           /** 生成新的列表 */

        dishItemList.stream()
                    .filter(DishItem::isCanDisc)                  /** 过滤打折 */
                    .collect(groupingBy(DishItem::getDishClass)); /** 根据菜品类型分组 */

        dishItemList.stream()
                    .filter(DishItem::isCanDisc)                       /** 过滤打折 */
                    .sorted(Comparator.comparing(DishItem::getPrice))  /** 价格排序 */
                    .collect(toList());

        dishItemList.stream()
                    .filter(DishItem::isCanDisc)                    /** 过滤打折 */
                    .max(Comparator.comparing(DishItem::getPrice))  /** 获取最贵的菜品 */
                    .get();
    }

    public static void stream2(List<DishItem> dishItemList) {
        dishItemList.stream()
                    .filter(DishItem::isCanDisc)  /** 过滤打折 */
                    .map(DishItem::getName)       /** 映射到菜名 */
                    .collect(toList());           /** 生成新的列表 */

        dishItemList.stream()
                .filter(dishItem -> dishItem.getName().equals("鱼香肉丝")) /** 过滤菜品 */
                .map(DishItem::getPrice)                                  /** 映射价格 */
                .findAny();                                               /** 查找任意一个 */

        dishItemList.stream()
                .filter(DishItem::isCanDisc)   /** 过滤菜品 */
                .map(DishItem::getPrice)       /** 映射价格 */
                .reduce(BigDecimal::add)       /** 求和    */
                .get();
    }

    static Path path;

    static int[] array;



    public static void stream3() throws IOException {
        /** 规则 -> 数据流 */
        Stream.generate(() -> Math.random());

        /** 起始, 规则 -> 数据流 */
        Stream.iterate(0, t -> t + 2);

        /** 从参数生成数据流 */
        Stream.of("Java", "Lambda", "Stream");

        /** 从数组生成数据流 */
        Arrays.stream(array);

        /** 从路径中生成文件流 */
        Files.list(path);

        /** 从文件中生成内容流 */
        Files.lines(path);
    }

}
