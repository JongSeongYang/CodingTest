package programmers.java.lv1;
/*
두 큐 합 같게 만들기
 */

import java.util.*;

public class Pg118667 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long s1 = 0;
        long s2 = 0;
        long sum = 0;
        for(int q : queue1){
            q1.add(q);
            s1+=q;
        }
        for(int q : queue2){
            q2.add(q);
            s2+=q;
        }
        sum = s1+s2;
        if(sum%2 != 0) return -1;
        sum /=2;
        int n1 = 0;
        int n2 = 0;
        int limit = q1.size()*2;
        while (n1<=limit && n2<=limit) {
            if (s1 == sum) return n1+n2;
            if (s1>sum) {
                s1-=q1.peek();
                s2+=q1.peek();
                q2.add(q1.poll());
                n1++;
            } else {
                s2-=q2.peek();
                s1+=q2.peek();
                q1.add(q2.poll());
                n2++;
            }
        }
        return answer;
    }
}
