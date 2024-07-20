package programmers.java.lv3;

import java.util.*;

// 표병합

public class Pg150366 {
    static String[][][] board = new String[51][51][3]; // [r][c][value, pointer_r, pointer_c]
    static List<String> answer = new ArrayList<>();

    public String[] solution(String[] commands) {

        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                board[i][j][0] = "";
                board[i][j][1] = String.valueOf(i);
                board[i][j][2] = String.valueOf(j);
            }
        }
        for(String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            String doing = st.nextToken();
            if("UPDATE".equals(doing)){
                if (st.countTokens() == 2) {
                    updateCellByValue(st.nextToken(), st.nextToken());
                }
                else {
                    updateCellByIndex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());
                }
            } else if("MERGE".equals(doing)){
                mergeCell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
                        ,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else if("UNMERGE".equals(doing)){
                unmergeCell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else if("PRINT".equals(doing)){
                printCell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }

        return answer.toArray(new String[answer.size()]);
    }

    static void updateCellByIndex(int r, int c, String after) {
        int headR = Integer.parseInt(board[r][c][1]);
        int headC = Integer.parseInt(board[r][c][2]);
        board[headR][headC][0] = after;
    }

    static void mergeCell(int r1, int c1, int r2, int c2) {
        int headR1 = Integer.parseInt(board[r1][c1][1]);
        int headC1 = Integer.parseInt(board[r1][c1][2]);
        String headValue1 = board[headR1][headC1][0];

        int headR2 = Integer.parseInt(board[r2][c2][1]);
        int headC2 = Integer.parseInt(board[r2][c2][2]);
        String headValue2 = board[headR2][headC2][0];

        if(headR1 == headR2 && headC1 == headC2)
            return;

        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                int tmpR = Integer.parseInt(board[i][j][1]);
                int tmpC = Integer.parseInt(board[i][j][2]);
                if(headR2 == tmpR && headC2 == tmpC){
                    board[i][j][1] = String.valueOf(headR1);
                    board[i][j][2] = String.valueOf(headC1);
                }
            }
        }

        board[headR2][headC2][0] = "";
        if(headValue1.equals(""))
            board[headR1][headC1][0] = headValue2;
    }

    static void unmergeCell(int r, int c) {
        int headR = Integer.parseInt(board[r][c][1]);
        int headC = Integer.parseInt(board[r][c][2]);
        String headValue = board[headR][headC][0];

        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                int tmpR = Integer.parseInt(board[i][j][1]);
                int tmpC = Integer.parseInt(board[i][j][2]);
                if(headR == tmpR && headC == tmpC){
                    board[i][j][1] = String.valueOf(i);
                    board[i][j][2] = String.valueOf(j);
                }
            }
        }

        board[headR][headC][0] = "";
        board[r][c][0] = headValue;
    }

    static void updateCellByValue(String before, String after) {
        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                if(before.equals(board[i][j][0])){
                    board[i][j][0] = after;
                }
            }
        }
    }

    static void printCell(int r, int c) {
        int headR = Integer.parseInt(board[r][c][1]);
        int headC = Integer.parseInt(board[r][c][2]);
        String headValue = board[headR][headC][0];

        if( headValue.equals(""))
            answer.add("EMPTY");
        else
            answer.add(headValue);
    }
}
