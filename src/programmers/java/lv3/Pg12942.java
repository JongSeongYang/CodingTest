package programmers.java.lv3;

import java.util.*;

// 최적의 행렬 곱셈

public class Pg12942 {
    static int[][] dp;
    static int num;
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        num = matrix_sizes.length;

        dp = new int[num][num];
        for(int i = 0; i < num; i++) {
            Arrays.fill(dp[i], -1);
        }

        return find(matrix_sizes, 0, num-1);
    }

    static int find(int[][] matrix_sizes, int start, int end) {
        if(start == end) return 0;
        if(dp[start][end] != -1) return dp[start][end];

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < end - start; i++) {
            int mid = start + i;
            int front = find(matrix_sizes, start, mid);
            int back = find(matrix_sizes, mid+1, end);
            int now = matrix_sizes[start][0] * matrix_sizes[mid][1] * matrix_sizes[end][1];

            result = Math.min(result,front+back+now);
        }

        return result;
    }
}
