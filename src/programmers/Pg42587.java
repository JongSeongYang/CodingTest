package programmers;

// 프린터

import java.util.Collections;
import java.util.PriorityQueue;

public class Pg42587 {
    public static void main(String[] args) {
        Solution42587 solution42587 = new Solution42587();
         System.out.println(solution42587.solution(new int[]{2, 1, 3, 2}, 2));
    }
}

class Solution42587 {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Object> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities)
            pq.add(p);

        while(!pq.isEmpty()){
            for(int i = 0;i<priorities.length;i++){
                if(priorities[i] == (int)pq.peek()){
                    if(i == location)
                        return answer;
                    answer++;
                    pq.poll();
                }
            }
        }
        return answer;
    }
}
