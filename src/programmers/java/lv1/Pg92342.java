package programmers.java.lv1;
import java.util.*;
/*
양궁대회
 */
public class Pg92342 {
    static int[] answer;
    static int maxScore = -1;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        dfs(new int[11], n,info, 0);
        if(maxScore == -1)
            return new int[]{-1};
        return answer;
    }
    static void dfs(int[] lion, int cnt, int[] info, int idx){
        // 화살을 다 쐈을때
        if(cnt == 0){
            int[] result = checkSum(lion, info);
            // 라이언이 더 높은 점수라면
            if(result[0] < result[1]){
                // 기존보다 더 높은 점수 차이면
                if(maxScore < (result[1] - result[0])){
                    answer = lion.clone();
                    maxScore = result[1] - result[0];
                }
                // 기존과 같은 점수인데 낮은 과녁을 많이 맞췄다면
                else if(maxScore == (result[1] - result[0])){
                    if(checkNum(lion))
                        answer = lion.clone();
                }
            }
            return;
        }
        for(int i = idx; i<11;i++){
            if(lion[i] <= info[i]){
                lion[i]++;
                dfs(lion, cnt-1, info, i);
                lion[i]--;
            }
        }
    }

    static int[] checkSum(int[] lion, int[] info){
        int sumLion = 0;
        int sumInfo = 0;
        for(int i = 0; i < 11; i++){
            // 어피치가 맞췄고, 라이언 이상 맞췄으면
            if(info[i] != 0 && info[i] >= lion[i])
                sumInfo += (10-i);
                // 라이언이 더 많이 맞췄으면
            else if(info[i] < lion[i])
                sumLion += (10-i);
        }
        return new int[]{sumInfo, sumLion};
    }

    static boolean checkNum(int[] lion){
        int numLion = 0;
        int numAns = 0;
        int n = 10;
        // 낮은 점수부터 맞춘 개수 비교
        while(n >= 0 && (lion[n] == answer[n])){
            n--;
        }
        if(n != -1 && lion[n] > answer[n]) return true;
        // false 반환
        // 1. n == -1 : 전부 같은경우
        // 2. lion[n] < answer[n] : 기존의 개수가 더 많은 경우
        return false;
    }
}
