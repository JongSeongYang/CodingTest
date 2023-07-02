package programmers.java.lv1;

import java.util.*;

public class Pg169199 {
    static char[][] b;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Pos{
        private int y;
        private int x;
        private int cnt;

        Pos(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static Pos start;
    static Pos goal;
    public int solution(String[] board) {
        int answer = 0;
        b = new char[board.length][board[0].length()];
        check = new boolean[b.length][b[0].length];
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j<board[0].length();j++){
                if(board[i].charAt(j) == 'R')
                    start = new Pos(i,j,0);
                else if(board[i].charAt(j) == 'G')
                    goal = new Pos(i,j,0);
                b[i][j] = board[i].charAt(j);
            }
        }
        return bfs(start);
    }
    static Pos nextPos(int index, Pos now){
        int y = now.y;
        int x = now.x;
        int cnt = now.cnt;
        while(y + dy[index] >= 0 && y + dy[index] < b.length
                && x + dx[index] >= 0 && x + dx[index] < b[0].length
                && b[y + dy[index]][x + dx[index]] != 'D'){
            y += dy[index];
            x += dx[index];
        }
        return new Pos(y,x, cnt+1);
    }

    static int bfs(Pos start){
        Queue<Pos> q = new LinkedList<>();
        q.offer(start);
        check[start.y][start.x] = true;

        while(!q.isEmpty()){
            Pos now = q.poll();
            if(goal.x == now.x && goal.y == now.y){
                return now.cnt;
            }
            for(int i = 0;i<4;i++){
                Pos next = nextPos(i,now);
                if(!check[next.y][next.x]){
                    check[next.y][next.x] = true;
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}
