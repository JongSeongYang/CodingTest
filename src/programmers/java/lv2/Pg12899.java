package programmers.java.lv3;

import java.util.*;

// 124나라의 숫자

public class Pg12946 {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        
        while(n > 0) {
            int rest = n % 3;
            n = n/3;
            
            if(rest == 0) {
                n -= 1;
            } 
            answer = numbers[rest] + answer;
         
        }
        return answer;
    }
}
