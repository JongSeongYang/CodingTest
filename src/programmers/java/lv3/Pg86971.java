package programmers.java.lv3;

import java.util.*;

// 전력망 둘로 나누기

public class Pg86971 {

    static int answer;
    static int[] visited;
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        answer = n;
        arr = new int[n+1][n+1];
        for(int[] w : wires) {
            arr[w[0]][w[1]] = 1;
            arr[w[1]][w[0]] = 1;
        }

        for(int[] w : wires) {
            arr[w[0]][w[1]] = 0;
            arr[w[1]][w[0]] = 0;
            visited = new int[n+1];
            int num = 0;

            for(int i = 1; i <= n; i++) {
                // 방문하지 않은 송전탑의 경우
                if(visited[i] != 1){
                    if(num == 0)
                        num = bfs(i, n);
                    else
                        num = Math.abs(num-bfs(i,n));
                }
            }
            answer = Math.min(answer, num);

            arr[w[0]][w[1]] = 1;
            arr[w[1]][w[0]] = 1;
        }

        return answer;
    }

    static int bfs(int num, int n){
        visited[num] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        int towerNum = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 1; i <= n; i++){
                if(visited[i] == 0 && arr[now][i] == 1) {
                    visited[i] = 1;
                    q.offer(i);
                    towerNum ++;
                }
            }
        }
        return towerNum;
    }
}
