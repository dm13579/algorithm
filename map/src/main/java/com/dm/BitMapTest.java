package com.dm;

/**
 * BitMap 测试
 * <p>
 * Q: 在3亿个数（0~2亿）中判断一个数是否存在？
 * A: 数组：首先考虑数组发现用数组需要开辟2亿个空间;初始化数组全为0;
 * 假设有一个数是5，就让a[5] = 1,找数的时候直接用数组下标判这个位置的值是否为1;
 * 所占空间2亿*4(byte)/1024/1024 = 762.9M;所占空间极大，运算速度快
 * <p>
 * A：一个int是4byte是32位，如果我们用位来存储会使上面的空间降低32倍=762.9/32 = 23.8M大大降低空间
 * <p>
 * 实现思路:
 * 一个int 32位
 * 00000000 00000000 00000000 00000000
 * 假设我们有一个数是5
 * 就将1 << 5
 * 00000000 00000000 00000000 00100000
 * 假设我们有一个数是46
 * 我们可以46/32 = 1 46%32 = 14 那么显然int数组多开辟一个空间且这个空间中1 << 14
 * 00000000 00000000 01000000 00000000
 * 此时int数组应为
 * data[0] = 00000000 00000000 00000000 00100000 = 32
 * data[1] = 00000000 00000000 01000000 00000000 = 16384
 */
public class BitMapTest {

    /**
     * 开辟一个int数组
     */
    private int[] dataArray;

    /**
     * 最大的数
     */
    private int max;

    private BitMapTest(int max) {
        this.max = max;
        // max/32 + 1 便为 最大开辟空间
        dataArray = new int[(max >> 5) + 1];
    }

    /**
     * 添加
     *
     * @param data 插入的数据
     */
    private void add(int data) {
        if (data > max) {
            return;
        }
        // data/32 为数组index
        // data%32 为数组index中1<<位数
        int index = data >> 5;
        int dis = data & 31;

        System.out.println("添加前二进制:" + Integer.toBinaryString(dataArray[index]));
        dataArray[index] |= (1 << dis);
        System.out.println("添加后二进制:" + Integer.toBinaryString(dataArray[index]));
        System.out.println();

    }

    /**
     * 移除
     *
     * @param data 插入的数据
     */
    private void remove(int data) {
        int index = data >> 5;
        int dis = data & 31;
        System.out.println("删除前二进制:" + Integer.toBinaryString(dataArray[index]));
        dataArray[index] &= ~(1 << dis);
        System.out.println("删除后二进制:" + Integer.toBinaryString(dataArray[index]));
        System.out.println();
    }

    /**
     * 查找
     *
     * @param data 插入的数据
     * @return boolean
     */
    private boolean find(int data) {
        int index = data >> 5;
        int dis = data & 31;
        return (dataArray[index] & (1 << dis)) != 0;
    }

    public static void main(String[] args) {
        BitMapTest bitMapTest = new BitMapTest(128);
        bitMapTest.add(5);
        bitMapTest.add(46);
        bitMapTest.add(98);

        System.out.println("查找98：" + bitMapTest.find(98));
        bitMapTest.remove(98);
        System.out.println("移除98后查找98：" + bitMapTest.find(98));
        System.out.println();
        System.out.println("查找46：" + bitMapTest.find(98));
        bitMapTest.remove(46);
        System.out.println("移除46后查找46：" + bitMapTest.find(46));
    }


}
