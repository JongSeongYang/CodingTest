package programmers;

// 주식 가격

import java.util.Arrays;

public class Pg42584 {
    public static void main(String[] args) {
        Solution42584 solution42584 = new Solution42584();
        System.out.println(Arrays.toString(solution42584.solution(new int[]{1, 2, 3, 2, 3})));
    }
}

class Solution42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int next = 0;
        for(int i = 0;i<prices.length;i++){
            int sec = 0;
            for(int j = i+1;j < prices.length;j++){
                if(prices[i] <= prices[j]) {
                    sec++;
                }
                else{
                    sec++;
                    break;
                }
            }
            answer[i] = sec;
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}
