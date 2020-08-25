package com.dm.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        Integer data[] = {8, 4, 20, 7, 3, 1, 25, 14, 17};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 堆排序
     */
    public static void heapSort(Integer data[]) {

        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeap(data, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            Integer temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            // 0~i堆化已经排好序了
            maxHeap(data, 0, i);
        }
    }

    /**
     * 堆化過程；建一个大顶堆,end表示最多建到的点
     */
    public static void maxHeap(Integer data[], int start, int end) { //
        int parent = start;
        // 下标是从0开始的要加1
        int son = parent * 2 + 1;
        while (son < end) {
            int temp = son;
            // 比较左右节点和父节点的大小
            if (son + 1 < end && data[son] < data[son + 1]) {
                // 表示右节点比左节点大，换右节点跟父节点
                temp = son + 1;
            }
            // temp: 左右节点大的那一个
            if (data[parent] > data[temp]) {
                // 不用交换
                return;
            } else {
                // 交换
                swap(data, temp, parent);
                // 继续堆化
                parent = temp;
                son = parent * 2 + 1;
            }
        }
    }

    /**
     * 元素交换
     */
    private static void swap(Integer[] array, int i, int j) {
        // 二数交换  可优化
        // 1,普通方法
//                if(array[i] > array[j]){
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
        // 2,加减方法,没有临时变量,假设a=2,b=3,接下来b = a + b = 5;a = b - a = 5 - 2 = 3; b = b - a = 5 - 3 = 2;
//                if(array[i] > array[j]){
//                    array[j] =  array[i]+array[j];    // b = a + b = 5;     此时a = 2,b = 5;
//                    array[i] = array[j] - array[i];     // a = b - a = 5 - 2 = 3; 此时a = 3,b = 5;
//                    array[j] = array[j] - array[i];   // b = b - a = 5 - 3 = 2 此时a = 3,b = 2;
        // 3,异或方法，没有临时变量,假设a=2,b=3,二进制也就是a=10,b=11异或后a=a^b=11^10=01,b=a^b=01^11=10,a=a^b=01^10=11
        if (array[i] > array[j]) {
            array[i] = array[i] ^ array[j];      // a=a^b=11^10=01;   a=01,b=11
            array[j] = array[i] ^ array[j];    // b=a^b=01^11=10    a=01,b=10
            array[i] = array[i] ^ array[j];      // a=a^b=01^10=11    a=11,b=10
        }
    }

}
