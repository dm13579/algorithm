package com.dm;

/**
 * @author dm
 * @className: leetcode_96
 * @description: 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 动态规划
 * @date 2020/7/15
 * @since JDK1.8
 *
 * 假设 1,2,3,4,5,6
 *
 * 假设长度为n的序列可构成的二叉搜索树为Number[n],那么Number[0] = 1,Number[1] = 1;
 * 假设F(i,n)表示以i为根 长度为n的序列的不同二叉搜索树;
 *
 * Number[2] = F(1,2) + F(2,2)
 * Number[3] = F(1,3) + F(2,3) + F(3,3)
 * Number[4] = F(1,4) + F(2,4) + F(3,4) + F(4,4)
 * Number[5] = F(1,5) + F(2,5) + F(3,5) + F(4,5) + F(5,5)
 * Number[6] = F(1,6) + F(2,6) + F(3,6) + F(4,6) + F(5,6) + F(6,6)
 *
 * 可知Number[n] = F(1,n) + F(2,n) + ...... + F(n,n);
 *
 * 现在只要知道F(i,n)怎么得出问题就解决了;
 *
 * F(i,n) 可以分成 1~i-1  i  i+1~n 三部分i为根节点 1~i-1为左子树 i+1~n为右子树
 * 左子树构建的不同二叉搜索树与右子树构建的不同二叉搜索树的笛卡尔积及时F(i,n)的值
 *
 * F(i,n) = Number(i-1) * Number(n-i)
 *
 * Number[2] = Number(0)*Number(1) + Number(1)Number(0) = 2
 * Number[3] = Number(0)*Number(2) + Number(1)*Number(1) + Number(2)*Number(0) = 5
 * Number[4] = 0,3 + 1,2 + 2,1 + 3,0 = 5 + 2 + 2 + 5 = 14
 * Number[5] = 0,4 + 1,3 + 2,2 + 3,1 + 4,0 = 14 + 5 + 4 + 5 + 14 = 42
 * Number[6] = 0,5 + 1,4 + 2,3 + 3,2 + 4,1 + 5,0 = 42 + 14 + 10 + 10 + 14 + 42 = 132
 *
 *
 * Number[n]= Number[0]*Number[n−1] + Number[1]*Number[n−2] + Number[2]*Number[n−3] + ......  + Number[n-1]*Number[0]
 */
public class leetcode_96 {
    public static void main(String[] args) {
        int n = 6;

        System.out.println(numTrees(n));
    }

    private static Integer numTrees(int n) {
        Integer[] number = new Integer[n + 1];
        number[0] = 1;
        number[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                number[i] += number[j - 1] * number[i - j];
            }
        }
        return number[n];
    }
}
