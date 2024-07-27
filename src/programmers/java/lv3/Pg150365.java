package programmers.java.lv3;

import java.util.*;

// 미로 탈출 명령어

public class Pg150365 {
    static class Pos {
        private int x;
        private int y;
        private int depth;
        private String s;

        Pos(int x, int y, int depth, String s){
            this.y = y;
            this.x = x;
            this.depth = depth;
            this.s = s;
        }
    }
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] c = {'d', 'l', 'r','u'};
    static List<String> list = new ArrayList<>();
    static boolean[][][] check;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int minLen = Math.abs(x-r) + Math.abs(y-c);
        check = new boolean[n][m][k+1];
        // 최소거리와 K가 모두 2로 나눴을때 나머지가 같아야함
        // 최소거리보다 작은 K는 불가능
        if(minLen%2 != k%2 || minLen > k) return "impossible";
        bfs(new Pos(x-1,y-1,0,""), new Pos(r-1,c-1,0,""), k,n,m);
        Collections.sort(list);
        return list.get(0);
    }
    static void bfs(Pos start, Pos end, int k, int n, int m){
        Queue<Pos> q = new LinkedList<>();
        q.offer(start);
        check[start.x][start.y][0] = true;
        while(!q.isEmpty()){
            Pos p = q.poll();
            if(p.depth == k && p.y == end.y && p.x == end.x){
                list.add(p.s);
                continue;
            }
            for(int i = 0;i<4;i++){
                int nextY = p.y + dy[i];
                int nextX = p.x + dx[i];
                int nextDepth = p.depth + 1;
                if(nextY >=0 && nextY < m && nextX >= 0 && nextX <n && nextDepth <= k
                        && !check[nextX][nextY][nextDepth]){
                    String nextS = p.s + c[i];
                    check[nextX][nextY][nextDepth] = true;
                    q.add(new Pos(nextX, nextY, nextDepth, nextS));
                }
            }
        }
    }
}
