package programmers.java.lv3;

import java.util.*;

// 카운트 다운

public class Pg131129 {
    static int[][] dp;
    public int[] solution(int target) {
        int[] answer;
        dp = new int[target+1][2]; // [최소 횟수][싱글+불 횟수]
        // init dp
        for(int i = 1;i <= target; i++){
            dp[i][0] = 100001;
            dp[i][1] = 0;
        }

        // a[target] = a[target-n] + a[n]
        // 9 -> 3 triple or 9 single
        // 51 -> 17*3
        answer = find(target);

        return answer;
    }

    static int[] find(int score) {
        if(dp[score][0] == 100001){
            if(score >= 50){
                int[] nextScore = find(score - 50);
                if(nextScore[0] + 1 < dp[score][0] || (nextScore[0] + 1 == dp[score][0] && nextScore[1]+1 > dp[score][1])){
                    dp[score][0] = nextScore[0] + 1;
                    dp[score][1] = nextScore[1] + 1;
                }
            }

            int remain = score >= 20 ? 20 : score;
            for(int i = remain; i >= 1; i--){
                for(int j = 1; j <= 3; j++){
                    if(score >= i*j){
                        int[] nextScore = find(score - i*j);
                        int cnt = j == 1 ? 1 : 0;
                        if(nextScore[0] + 1 < dp[score][0] || (nextScore[0] + 1 == dp[score][0] && nextScore[1]+cnt > dp[score][1])){
                            dp[score][0] = nextScore[0] + 1;
                            dp[score][1] = nextScore[1] + cnt;
                        }

                    }
                }
            }
        }
        return dp[score];
    }
}
