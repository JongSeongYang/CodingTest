package programmers.java.lv1;
import java.util.*;
/*
k진수에서 소수 개수 구하기
 */
public class Pg92335 {
    public int solution(int n, int k) {
        int answer = 0;
        String[] tmp = Long.toString(n,k).split("0");
        for(String t : tmp)
            if(!t.equals("") && isPrime(Long.parseLong(t)))
                answer++;
        return answer;
    }
    public static boolean isPrime(long n) {
        if(n == 1) return false;
        for (int i = 2; i<=(long)Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
