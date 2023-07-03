package programmers.java.lv1;

import java.util.*;
/*
무인도 여행
 */
public class Pg154540 {
    static int[][] m;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> answer = new ArrayList<>();
    static class Pos {
        private int y;
        private int x;

        public Pos (int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public int[] solution(String[] maps) {
        int cnt = 0;
        m = new int[maps.length][maps[0].length()];
        check = new boolean[m.length][m[0].length];
        for(int i = 0;i<m.length;i++){
            for(int j = 0; j<m[0].length;j++){
                char c = maps[i].charAt(j);
                if(c == 'X')
                    m[i][j] = 0;
                else{
                    m[i][j] = c-'0';
                    cnt += 1;
                }
            }
        }
        if(cnt == 0)
            return new int[]{-1};
        for(int i = 0;i<m.length;i++){
            for(int j = 0; j<m[0].length;j++){
                if(!check[i][j] && m[i][j] != 0)
                    answer.add(bfs(new Pos(i,j)));
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(x->x).toArray();
    }
    static int bfs(Pos start) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(start);
        check[start.y][start.x] = true;
        int sum = 0;
        while(!q.isEmpty()){
            Pos now = q.poll();
            sum += m[now.y][now.x];
            for(int i = 0;i<4;i++){
                int nextY = now.y+dy[i];
                int nextX = now.x+dx[i];
                if(nextY >= 0 && nextY < m.length
                        && nextX >= 0 && nextX < m[0].length
                        && m[nextY][nextX] != 0
                        && !check[nextY][nextX]){
                    q.offer(new Pos(nextY,nextX));
                    check[nextY][nextX] = true;
                }
            }
        }
        return sum;
    }
}
