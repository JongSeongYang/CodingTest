package programmers.java.lv2;

import java.util.*;

// 우박수열 정적분

public class Pg134239 {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> sum  = new ArrayList<>();
        int maxLen = 0;
        int before = 0;
        double beforeSum = 0.0;
        sum.add(beforeSum);
        while(k > 1) {
            // 수열 구하기
            before = k;
            if(k%2 == 0){
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
            maxLen ++;
            // 누적합 구하기
            double now = (double)(before+k)/2;
            beforeSum += now;
            sum.add(beforeSum);
        }

        for(int i = 0; i< ranges.length; i++) {
            int from = ranges[i][0];
            int to = maxLen + ranges[i][1];
            // 유효하지 않는 구간 체크
            if(from > to) {
                answer[i] = -1.0;
                continue;
            } else if(to == from) {
                answer[i] = 0.0;
                continue;
            } else {
                answer[i] = sum.get(to) - sum.get(from);
            }
        }

        return answer;
    }
}
