package bok;

// 경사로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class bj14890 {
    InputStream in;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int L;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        L = Integer.parseInt(a[1]);
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int answer = 0;
        // 가로
//        for (int i = 0; i < N; i++) {
//            int[] check = new int[N];
//            if(i>=L && )
//        }
    }
}
