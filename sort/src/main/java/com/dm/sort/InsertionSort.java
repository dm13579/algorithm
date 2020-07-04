package com.dm.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    // 插入排序
    public static void sort(Integer []array){
        int length = array.length;
        int pre,cur;
        // 33154 => 33154 => 13354 => 13354 => 13345
        // 空间复杂度O(1)时间复杂度最优情况{13354}不会走while循环为O(n),最差情况为O(n^2)平均O(n^2)稳定性：稳定
        for(int i=1;i<length;i++){
            // 当前节点前一位数组下标
            pre = i-1;
            // 当前节点值
            cur = array[i];
            while(pre >= 0 && array[pre] > cur){
                // 后移元素
                array[pre+1] = array[pre];
                // 向前遍历
                pre--;
            }
            array[pre+1] = cur;
        }

    }

    public static void main(String[] args) {
        Integer []array = {50,10,90,30,70,40,80,60,20};
        sort(array);
        for(Integer value : array){
            System.out.print(value + ";");
        }
    }
}
