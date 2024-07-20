package programmers.java.lv3;

import java.util.*;

// 최고의 집합

public class Pg12938 {
    public int[] solution(int n, int s) {
        // n이 s보다 크면 불가능한 경우
        if(n > s) return new int[] {-1};
        
        int[] answer = new int[n];
        int result = s/n;
        int rest = s%n;
        for(int i = n-1; i >= 0; i--){
            answer[i] = result;
            if(rest > 0) {
                answer[i] += 1;
                rest --;
            }
        }
        return answer;
    }
}
