package programmers;

// 프로그래머스 구명보트

import java.util.*;
public class pg42885 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] people = new int[]{70, 80, 50, 50};
        System.out.println(solution.solution(people, 100));
    }

}

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        while(true){
            if(start > end) break;
            if(start == end){
                answer++;
                break;
            }
            if(people[start]+people[end]<=limit){
                start++;
            }
            end--;
            answer++;
        }
        return answer;
    }
}
