package cn.ieayoio.effective_java2.n42;

import java.util.Arrays;

/**
 * Created by ieayoio on 2017/12/15.
 */
public class Main {


    public static void main(String[] args) {

        /**
         * 原例
         * 这是书中的一个例子，Arrays.asList在传入可变参数时，
         * 可以将结果正常打印出来，然而在传入int[]时,
         * 打印出了[[I@511d50c0]的结果
         */
        System.out.println("原例：");
        System.out.println(Arrays.asList(3, 4, 5)); // [3, 4, 5]

        int[] digits = {3, 1, 4, 5, 3, 4, 3};
        System.out.println(Arrays.asList(digits)); // [[I@511d50c0]

        System.out.println(Arrays.toString(digits));


        /**
         * 测试1
         * 尝试自己写一个test1传入digits，
         * 调试进入函数时f为{int[7]@xxx}
         * 正常遍历出了int数组的内容，这和书中例子得到了不一样的结论
         * 点开Arrays.asList源码，可以看到结构如下：
         * public static <T> List<T> asList(T... a)
         *
         */

        System.out.println("测试1：");
        test1(digits); // 3 1 4 5 3 4 3


        /**
         * 测试2
         * 尝试再次编写test2方法，将参数改为泛型T
         * 调试进入函数时f为{int[1][]@xxx}
         * 这样做无法 遍历出了digits数组，这样得到了和书中相同的结论
         */
        System.out.println("测试2：");
        test2(digits);// [I@7a46a697


        /**
         * 测试3
         * 尝试将digits变为Integer[],再次传入test2
         * 调试进入函数时f为{Integer[7]@xxx}
         * 这样再次成功遍历出数组中的内容
         */
        System.out.println("测试3：");
        Integer[] digits2 = {3, 1, 4, 5, 3, 4, 3};
        test2(digits2); // 3 1 4 5 3 4 3


        /**
         * 总结:
         * 泛型可变参数传入原始类型数组时，可变参数会将整个数组识别为一个元素
         * 泛型可变参数传入包装类型数组时，可以正常识别
         */


    }


    public static void test1(int... f) {
        for (int i : f) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static <T> void test2(T... f) {
        for (T i : f) {
            System.out.print(i + " ");
        }
        System.out.println();


    }
}
