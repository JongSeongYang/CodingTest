package programmers.java.lv1;
import java.util.*;
/*
연속된 부분 수열의 합
 */
public class Pg178870 {

    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {-1,-1};
            int minLen = sequence.length;
            int start = 0;
            int sum = 0;
            for(int end = 0;end<sequence.length;end++){
                sum += sequence[end];
                while(sum > k)
                    sum -= sequence[start++];
                if(sum == k){
                    if(minLen > end - start){
                        answer = new int[]{start, end};
                        minLen = end-start;
                    }
                    else if(minLen == end - start && answer[0] > start){
                        answer = new int[]{start, end};
                        minLen = end-start;
                    }
                }
            }

            return answer;
        }
    }
}
