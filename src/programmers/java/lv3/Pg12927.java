package programmers.java.lv3;

import java.util.*;

// 야근지수

public class Pg12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            q.offer(works[i]);
        }

        for(int i = 0; i < n; i++) {
            if(q.isEmpty()) break;
            int time = (int)q.poll() - 1;
            if(time > 0)
                q.offer(time);
        }

        // 야근 피로도 계산
        while(!q.isEmpty()) {
            int time = q.poll();
            answer += (time * time);
        }

        return answer;
    }
}
