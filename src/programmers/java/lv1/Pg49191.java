package programmers.java.lv1;
import java.util.*;
/*
순위
 */
public class Pg49191 {
    static int[][] arr;
    static int answer;
    public int solution(int n, int[][] results) {
        arr = new int[n][n];
        for(int[] a : arr)
            Arrays.fill(a,1000);
        answer = n;
        for(int i = 0;i<results.length;i++){
            arr[results[i][0]-1][results[i][1]-1] = 1;
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i==j)
                    arr[i][j] = 0;
            }
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j]>arr[i][k]+arr[k][j])
                        arr[i][j] = arr[i][k]+arr[k][j];
                }
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i != j){
                    if(arr[i][j] == 1000 && arr[j][i] == 1000){
                        answer--;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
