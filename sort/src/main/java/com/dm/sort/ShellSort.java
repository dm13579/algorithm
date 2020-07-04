package com.dm.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    // 希尔排序
    public static void sort(Integer []array){
        int length = array.length;
        // 增量gap,且逐步缩减增量gap
        // gap为数组所分组数例如：33154就是分为2组{314},{35}分组后会插入排序变为{134}，{35}数组为{13345}分为1组为{13345}排序结束
        // 空间复杂度O(1)时间复杂度最优情况O(n^3/2),最差情况为O(n^2)平均O(n)稳定性：不稳定
        for(int gap = length/2;gap>0;gap/=2){

            // 从第gap个元素进行插入排序
            for(int i=gap;i<length;i++){
                int j = i;
                while(j-gap >= 0 && array[j-gap] > array[j]) {
                    // 交换元素
                    swap(array,j-gap,j);
                    // 向前遍历
                    j -= gap;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer []array = {50,10,90,30,70,40,80,60,20};

        sort(array);

        for(Integer value : array){
            System.out.println(value);
        }
    }

    /**
     * 元素交换
     */
    private static void swap(Integer []array,int i,int j){
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
        if(array[i] > array[j]) {
            array[i] = array[i]^array[j];      // a=a^b=11^10=01;   a=01,b=11
            array[j] = array[i]^array[j];    // b=a^b=01^11=10    a=01,b=10
            array[i] = array[i]^array[j];      // a=a^b=01^10=11    a=11,b=10
        }
    }
}
