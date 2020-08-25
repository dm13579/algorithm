package com.dm;

/**
 * 动态规划-力扣35
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class leetcode_35 {
    /**
     * 开辟一个int数组
     */
    private static int[] dataArray;

    /**
     * 最大的数
     */
    private static int max;

    public static void main(String[] args) {
        int[] nums = {0, 1, 5, 9};
        int target = 9;
        System.out.println(searchInsert(nums, target));

    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            }else if(target < nums[mid]) {
                end = mid;
            }else{
                return mid;
            }
        }
        return start;
    }


}
