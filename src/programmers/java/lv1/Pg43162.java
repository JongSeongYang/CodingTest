package programmers.java.lv1;
import java.util.*;
/*
네트워크
 */
public class Pg43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!check[i]){
                bfs(i,n,computers, check);
                answer++;
            }
        }
        return answer;
    }

    static void bfs(int start, int n, int[][] arr, boolean[] check){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0;i<n;i++){
                if(arr[tmp][i]==1 && !check[i]){
                    q.offer(i);
                    check[i] = true;
                }

            }
        }
    }
}
