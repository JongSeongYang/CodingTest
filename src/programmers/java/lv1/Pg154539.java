package programmers.java.lv1;
import java.util.*;
/*
뒤에 있는 큰 수 찾기
 */
public class Pg154539 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> s = new Stack<>();
            s.push(0);
            for(int i = 1;i<numbers.length;i++){
                while(true){
                    int tmp = s.pop();
                    if(numbers[tmp]>=numbers[i]){
                        s.push(tmp);
                        s.push(i);
                        break;
                    }
                    if(numbers[tmp]<numbers[i])
                        answer[tmp] = numbers[i];
                    if(s.isEmpty()){
                        s.push(i);
                        break;
                    }
                }
            }
            while(!s.isEmpty()){
                answer[s.pop()] = -1;
            }
            return answer;
        }
    }
}
