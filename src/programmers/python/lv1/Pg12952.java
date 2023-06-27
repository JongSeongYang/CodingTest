package programmers;

// N-Queen

public class Pg12952 {
    public static void main(String[] args) {
        Solution12952 solution12952 = new Solution12952();
        System.out.println(solution12952.solution(5));
    }
}

class Solution12952 {

    static int[] board;
    static int answer;
    static int N;

    public int solution(int n) {
        answer = 0;
        N = n;
        for(int i = 0 ; i < n ; ++i) {
            board = new int[n];
            board[0] = i;
            findSolution(1);
        }

        return answer;
    }

    private void findSolution(int row){
        if(row == N){
            answer++;
            board[row - 1] = 0;
            return;
        }

        for(int i = 0 ; i < N ; ++i){
            board[row] = i;
            if(checkDiagonal(row)){
                findSolution(row + 1);
            } else {
                board[row] = 0;
            }
        }
        board[row] = 0;
    }

    private boolean checkDiagonal(int row){
        for(int i = 0 ; i < row ; ++i){
            if(board[i] == board[row]) return false;
            if(Math.abs(row - i) == Math.abs(board[row] - board[i])) return false;
        }
        return true;
    }
}
