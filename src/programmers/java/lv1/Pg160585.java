package programmers.java.lv1;
/*
혼자서 하는 틱택토
 */
public class Pg160585 {
    public int solution(String[] board) {
        int answer = 1;
        // 빈 게임판이면 가능
        if(board[0].equals("...") && board[1].equals("...") && board[2].equals("..."))
            return 1;
        // O 와 X 개수 구하기
        int o = 0;
        int x = 0;
        for(int i = 0;i < 3; i++){
            for(int j = 0;j < 3; j++){
                if(board[i].charAt(j) == 'O')
                    o++;
                else if(board[i].charAt(j) == 'X')
                    x++;
            }
        }
        // X의 개수가 더 많으면 불가능
        if(x > o) return 0;
        // O의 개수가 X보다 두 개 이상 더 많으면 불가능
        if(o > x+1) return 0;
        // 승리조건 판단
        boolean oWin = false;
        boolean xWin = false;
        if((board[0].charAt(0) == 'O' && board[0].charAt(1) == 'O' && board[0].charAt(2) == 'O')
                || board[1].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[1].charAt(2) == 'O'
                || board[2].charAt(0) == 'O' && board[2].charAt(1) == 'O' && board[2].charAt(2) == 'O'
                || board[0].charAt(0) == 'O' && board[1].charAt(0) == 'O' && board[2].charAt(0) == 'O'
                || board[0].charAt(1) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(1) == 'O'
                || board[0].charAt(2) == 'O' && board[1].charAt(2) == 'O' && board[2].charAt(2) == 'O'
                || board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O'
                || board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O')
            oWin = true;
        // O가 승리조건이면 X의 개수가 하나 더 적어야함
        if(oWin && (o-x != 1)) return 0;
        // 둘다 승리조건이면 불가능
        if(!oWin && (board[0].charAt(0) == 'X' && board[0].charAt(1) == 'X' && board[0].charAt(2) == 'X')
                || board[1].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[1].charAt(2) == 'X'
                || board[2].charAt(0) == 'X' && board[2].charAt(1) == 'X' && board[2].charAt(2) == 'X'
                || board[0].charAt(0) == 'X' && board[1].charAt(0) == 'X' && board[2].charAt(0) == 'X'
                || board[0].charAt(1) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(1) == 'X'
                || board[0].charAt(2) == 'X' && board[1].charAt(2) == 'X' && board[2].charAt(2) == 'X'
                || board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X'
                || board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X')
            xWin = true;
        // X가 승리조건이면 둘의 개수가 다르면 불가능
        if(xWin && (o != x)) return 0;
        // 이 조건들 외에는 전부 가능
        return answer;
    }
}
