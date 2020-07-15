package com.dm.heaptree;

import java.util.Arrays;

/**
  * @className: TopK 
  * @description: Top K 问题  在一堆数中找到排名前几的数
  * @author dm
  * @date 2020/7/15
  * @since JDK1.8
  */
public class TopK {

    public static void main(String[] args) {
        int[] data = {8, 4, 20, 7, 3, 1, 25, 14, 17};
        int k = 5;
        // 构建大顶堆
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            HeapSort.heap(data, i, data.length);
        }
        System.out.println("堆化成大顶堆后的数组：");
        System.out.println(Arrays.toString(data));
        // 堆排序
        System.out.println("返回Top"+k+"结果：");
        for (int i = data.length - 1; i > data.length - 1- k; i--) {
            // data[0] data[i] 元素交换
            data[0] = data[0] ^ data[i];
            data[i] = data[0] ^ data[i];
            data[0] = data[0] ^ data[i];
            // 堆化到i就不能继续堆化了，因为i后面的值已经排好序了
            HeapSort.heap(data, 0, i);
            System.out.println(data[i]);
        }

    }
}
