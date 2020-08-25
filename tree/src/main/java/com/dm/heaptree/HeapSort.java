package com.dm.heaptree;

import java.util.Arrays;

/**
 * @author dm
 * @classname: HeapSort
 * @description: 堆排序
 * @date 2020/7/15
 * @since JDK1.8
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] data = {8, 4, 20, 7, 3, 1, 25, 14, 17};
        // 构建大顶堆
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            heap(data, i, data.length);
        }
        System.out.println("堆化成大顶堆后的数组：");
        System.out.println(Arrays.toString(data));
        // 堆排序
        for (int i = data.length - 1; i > 0; i--) {
            // data[0] data[i] 元素交换
            data[0] = data[0] ^ data[i];
            data[i] = data[0] ^ data[i];
            data[0] = data[0] ^ data[i];
            // 堆化到i就不能继续堆化了，因为i后面的值已经排好序了
            heap(data, 0, i);
        }
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(data));
    }

    /**
     * 堆化
     *
     * @param data  排序数组
     * @param start 开始堆化的点
     * @param end   堆化结束位置
     */
    public static void heap(int[] data, int start, int end) {
        int parent = start;
        // 下标是从0开始的就要加1，从1就不用
        int son = start * 2 + 1;

        // 这里不能等于因为下标从0开始
        while (son < end) {
            // temp 是在找2个子节点中最大的那个数
            int temp = son;
            // 表示右节点比左节点大，更新temp
            if (son + 1 < end && data[son] < data[son + 1]) {
                temp = son + 1;
            }

            if (data[parent] > data[temp]) {
                // 父节点大不用交换
                return;
            } else {
                // data[parent]和data[temp]交换元素
                data[parent] = data[parent] ^ data[temp];
                data[temp] = data[parent] ^ data[temp];
                data[parent] = data[parent] ^ data[temp];

                parent = temp;
                son = parent * 2 + 1;
            }
        }
    }
}
