package com.dm;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 动态规划-力扣785
 * @link https://leetcode-cn.com/problems/is-graph-bipartite/
 */
public class leetcode_785 {

    public static void main(String[] args) {
//        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] graph = {{1}, {0, 3}, {3}, {1, 2}};
        System.out.println(isBipartite(graph));

    }

    private static Boolean valid = true;

    public static boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        for (int node = 0; node < graph.length; node++) {
            // 已被标价
            if (color[node] != 0) {
                continue;
            }
            // BFS
            Queue<Integer> queue = new ArrayBlockingQueue<Integer>(graph.length);
            queue.add(node);
            // 标记这个点
            color[node] = 1;
            while (!queue.isEmpty()) {
                // 推出当前点
                int cur = queue.poll();
                Arrays.stream(graph[cur]).forEach(next -> {
                    if (color[next] == 0) {
                        color[next] = -color[cur];
                        queue.add(next);
                    } else {
                        // 表示2个点是否相反
                        if (color[next] != -color[cur]) {
                            valid = false;
                        }
                    }
                });
            }
        }
        return valid;
    }
}
