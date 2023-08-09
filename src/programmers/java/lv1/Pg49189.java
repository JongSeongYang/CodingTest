package programmers.java.lv1;
import java.util.*;
/*
가장 먼 노드
 */
public class Pg49189 {
    public int solution(int n, int[][] edge) {
        int dist[] = new int[n+1];
        boolean visit[][] = new boolean[n+1][n+1];
        for(int i=0; i<edge.length; i++){
            visit[edge[i][0]][edge[i][1]] = true;
            visit[edge[i][1]][edge[i][0]] = true;
        }

        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        int max = 0;

        while(!queue.isEmpty()){
            int idx = queue.poll();
            for(int j=2; j<=n; j++){
                if(dist[j] == 0 && visit[idx][j]){
                    dist[j] = dist[idx] + 1;
                    queue.add(j);
                }
            }
        }
        for(int i=0; i<n+1; i++){
            max = Math.max(max, dist[i]);
        }
        int cnt = 0;
        for(int i=0; i<n+1; i++){
            if(max == dist[i])
                cnt++;
        }

        return cnt;
    }
}
