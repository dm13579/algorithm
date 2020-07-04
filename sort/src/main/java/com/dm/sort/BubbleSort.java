package com.dm.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    // 冒泡排序
    public static void sort(Integer []array){
        int length = array.length;
        // 外层i表示要跑的趟数
        // 内层j表示移动次数
        // 33154 => 33145 => 33145 => 31345 => 13345
        // 空间复杂度O(1)时间复杂度最优情况{12345}为O(n)最差情况为O(n^2)平均O(n^2)稳定性：稳定
        for(int i=0;i<length;i++){
            // -i是后面i个是排好的，-1是最后一编不用排
            for(int j=0;j<length-i-1;j++){
                swap(array,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        Integer []array = {50,10,90,30,70,40,80,60,20};
        sort(array);
        for(Integer value : array){
            System.out.print(value + ";");
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
