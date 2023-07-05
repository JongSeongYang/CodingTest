package programmers.java.lv1;
import java.util.*;
/*
미로 탈출
 */
public class Pg159993 {
    static class Pos {
        private int y;
        private int x;
        private int time;

        public Pos(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int []dy = {0, 1, 0, -1};
    static boolean[][] check;
    static char[][] m;
    static Pos start;
    static Pos lever;
    static Pos exit;
    public int solution(String[] maps) {
        m = new char[maps.length][maps[0].length()];
        check = new boolean[m.length][m[0].length];
        for(int i = 0;i<maps.length;i++){
            for(int j = 0;j<maps[i].length();j++){
                char c = maps[i].charAt(j);
                m[i][j] = c;
                if(c == 'S') start = new Pos(i,j,0);
                else if(c == 'L') lever = new Pos(i,j,0);
                else if(c == 'E') exit = new Pos(i,j,0);
            }
        }
        int findLever = bfs(start, lever);
        if(findLever == -1) return -1;
        // 방문여부 초기화
        check = new boolean[m.length][m[0].length];
        int findExit = bfs(lever, exit);
        if(findExit == -1) return -1;
        return findLever + findExit;
    }
    static int bfs(Pos start, Pos goal){
        Queue<Pos> q = new LinkedList<>();
        q.offer(start);
        check[start.y][start.x] = true;

        while(!q.isEmpty()){
            Pos now = q.poll();
            if(now.y == goal.y && now.x == goal.x)
                return now.time;
            for(int i = 0;i<4;i++){
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];
                int time = now.time;
                if(nextY >= 0 && nextY < m.length && nextX >= 0 && nextX < m[0].length
                        && m[nextY][nextX] != 'X' && !check[nextY][nextX]){
                    check[nextY][nextX] = true;
                    q.offer(new Pos(nextY, nextX, time+1));
                }
            }
        }
        return -1;
    }
}
