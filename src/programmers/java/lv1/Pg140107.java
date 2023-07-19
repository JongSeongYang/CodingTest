package programmers.java.lv1;
/*
점 찍기
 */
public class Pg140107 {
    public long solution(int k, int d) {
        long answer = 0;
        for(long i = 0;i <= d;i+=k){
            answer += ((int)Math.sqrt((long)d*d - (long)i*i)/k+1);
        }
        return answer;
    }
}
