package com.dm;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * guava 不了2过滤器使用
 */
public class BloomFilterTest {

    public static void main(String[] args) {
        //我们要插入的数据也就是n
        int datasize = 100000000;
        //0.1%	误判率
        double fpp = 0.001;

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), datasize, fpp);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            bloomFilter.put(i);
        }
        System.out.println((System.currentTimeMillis() - start) + ":ms");


        // 测试误判率
        int t = 0;
        for (int i = 200000000; i < 300000000; i++) {
			//表示存在
            if (bloomFilter.mightContain(i)) {
                t++;
            }
        }

        System.out.println("误判的个数:" + t);

    }
}
