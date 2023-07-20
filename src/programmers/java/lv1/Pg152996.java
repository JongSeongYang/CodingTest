package programmers.java.lv1;
import java.util.*;
/*
시소 짝꿍
 */
public class Pg152996 {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        int cnt = 0;
        for(int i = 0;i<weights.length-1;i++){
            if(i>0){
                if(weights[i] == weights[i-1]){
                    cnt --;
                    answer += cnt;
                    continue;
                }
            }
            cnt = 0;
            for(int j = i+1; j<weights.length;j++){
                if(weights[i] == weights[j] || weights[i]*3 == weights[j]*2
                        || weights[i]*4 == weights[j]*2 || weights[i]*4 == weights[j]*3)
                    cnt +=1;
            }
            answer += cnt;
        }
        return answer;
    }
}
