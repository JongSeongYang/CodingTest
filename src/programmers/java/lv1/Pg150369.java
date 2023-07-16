package programmers.java.lv1;
/*
택배 배달과 수거하기
 */
public class Pg150369 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = 0;
        int p = 0;
        int cnt = 0;
        for(int i = n-1; i >= 0; i--){

            while(d < deliveries[i] || p < pickups[i]){
                d += cap;
                p += cap;
                cnt ++;
            }
            d -= deliveries[i];
            p -= pickups[i];
            answer += (i+1)*2*cnt;
            cnt = 0;
        }
        return answer;
    }
}
