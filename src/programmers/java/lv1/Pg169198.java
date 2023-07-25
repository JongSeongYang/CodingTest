package programmers.java.lv1;
import java.util.*;
/*
당구 연습
 */
public class Pg169198 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i = 0;i<balls.length;i++){
            int len1 = Integer.MAX_VALUE;
            int len2 = Integer.MAX_VALUE;
            int len3 = Integer.MAX_VALUE;
            int len4 = Integer.MAX_VALUE;
            // x 축 대칭시키기
            if(!(startX == balls[i][0] && startY >= balls[i][1]))
                len1 = (int)(Math.pow(balls[i][0] - startX, 2) + Math.pow(-1*balls[i][1] - startY, 2));
            // y축 대칭시키기
            if(!(startY == balls[i][1] && startX >= balls[i][0]))
                len2 = (int)(Math.pow(-1*balls[i][0] - startX, 2) + Math.pow(balls[i][1] - startY, 2));
            // 위쪽 벽에 대칭시키기
            if(!(startX == balls[i][0] && startY <= balls[i][1]))
                len3 = (int)(Math.pow(balls[i][0] - startX, 2) + Math.pow((n+n-balls[i][1]) - startY, 2));
            // 오른쪽 벽에 대칭시키기
            if(!(startY == balls[i][1] && startX <= balls[i][0]))
                len4 = (int)(Math.pow((m + m -balls[i][0]) - startX, 2) + Math.pow(balls[i][1] - startY, 2));

            answer[i] = Math.min(len1, Math.min(len2,Math.min(len3,len4)));
        }
        return answer;
    }
}
