package com.dm.sort;

/**
 * 归并排序
 */
public class MergeSort {

    // 排序过程
    static void merge(Integer []array,int low,int mid,int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while(i<=mid&&j<=high){
            if(array[i]<=array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }

        for (int k2 = 0; k2 < temp.length; k2++) {
            array[k2 + low] = temp[k2];
        }
    }

    // 归并排序
    public static void sort(Integer []array,int low,int high){
        int mid = low+(high - low)/2; // 防止数过大会超过Intgeer
        if(low < high){
            sort(array,low,mid);
            sort(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }

    public static void main(String[] args) {
        Integer []array = {50,10,90,30,70,40,80,60,20};

        sort(array,0,array.length-1);

        for(Integer value : array){
            System.out.print(value + ";");
        }
    }
}
