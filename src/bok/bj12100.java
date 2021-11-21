package bok;

// bj12100 2048(Easy)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj12100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] board;
    static int maxResult = 0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        moveBoard(0);
        System.out.println(maxResult);
    }

    static public void moveBoard(int num) {
        if(num == 5){
            maxResult = Math.max(findMaxInBoard(), maxResult);
            return;
        }
        else{
            int[][] originBoard = new int[N][N];
            for(int j = 0;j<N;j++)
                originBoard[j] = board[j].clone();
            for (int i = 0; i < 4; i++) {
                moveTile(i);
                //System.out.println("<<"+num+" "+i+">>");
                //printBoard();
                moveBoard(num+1);
                for(int j = 0;j<N;j++)
                    board[j] = originBoard[j].clone();
            }
        }
    }

    static public void moveTile(int dir) {
        // 왼쪽
        if(dir == 0){
            for (int i = 0; i < N; i++) {
                int[] arr = new int[N];
                int save = 0;
                int next = 0;
                while(next<N-1){
                    if(board[i][next] == board[i][next+1]) {
                        arr[save] = board[i][next]*2;
                        next+=2;
                    }
                    else {
                        arr[save] = board[i][next];
                        next++;
                    }
                    save++;
                }
                for(int j = 0;j<N;j++) {
                    board[i][j] = arr[j];
                }
            }
        }
        // 오른쪽
        else if(dir == 1){
            for (int i = N-1; i >= N; i--) {
                int save = N-1;
                int next = N-1;
                int[] arr = new int[N];
                while(next > 0){
                    if(board[i][next] == board[i][next-1]) {
                        arr[save] = board[i][next]*2;
                        next-=2;
                    }
                    else {
                        arr[save] = board[i][next];
                        next--;
                    }
                    save--;
                }
                for(int j = N-1;j>=0;j--) {
                    board[i][j] = arr[j];
                }
            }
        }
        // 위쪽
        else if(dir == 2){
            for (int i = 0; i < N; i++) {
                int save = 0;
                int next = 0;
                int[] arr = new int[N];
                while(next<N-1){
                    if(board[next][i] == board[next+1][i]) {
                        arr[save] = board[next][i]*2;
                        next+=2;
                    }
                    else {
                        arr[save] = board[next][i];
                        next++;
                    }
                    save++;
                }
                for(int j = 0;j<N;j++) {
                    board[j][i] = arr[j];
                }
            }
        }
        // 아래쪽
        else if(dir == 3){
            for (int i = N-1; i >= N; i--) {
                int save = N-1;
                int next = N-1;
                int[] arr = new int[N];
                while(next > 0){
                    if(board[next][i] == board[next-1][i]) {
                        arr[save] = board[next][i]*2;
                        next-=2;
                    }
                    else {
                        arr[save] = board[next][i];
                        next--;
                    }
                    save--;
                }
                for(int j = N-1;j>=0;j--) {
                    board[j][i] = arr[j];
                }
            }
        }
    }

    static public int findMaxInBoard() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, board[i][j]);
            }
        }
        return result;
    }

    static public void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
