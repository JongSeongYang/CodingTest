package programmers.java.lv1;
/*
억억단을 외우자
 */
public class Pg138457 {
    static int[] dp;
    static int[] cnt;
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        dp = new int[e+1];
        cnt = new int[e+1];
        dp[1] = 1;
        cnt[1] = 1;
        for(int i = 2;i<=e;i++){
            count(i,e);
        }
        int maxNum = 0;
        for(int i=e;i>=1;i--){
            if(dp[i] >= maxNum){
                maxNum = dp[i];
                cnt[i] = i;
            } else{
                cnt[i] = cnt[i+1];
            }
        }
        for(int i=0;i<starts.length;i++){
            answer[i] = cnt[starts[i]];
        }
        return answer;
    }
    static void count(int n, int e){
        int num = e/n;
        int j = n;
        for(int k=1;k<=num;k++){
            dp[j] += 1;
            j += n;
        }
    }
}
