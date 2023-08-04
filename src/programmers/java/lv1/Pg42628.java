package programmers.java.lv1;
import java.util.*;
/*
이중우선순위큐
 */
public class Pg42628 {
    static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for (String s : operations) {
            String tmp[] = s.split(" ");
            if (tmp[0].equals("I")) {
                int add = Integer.parseInt(tmp[1]);
                pq1.offer(add);
                pq2.offer(add);
                System.out.print(add + " ");
            } else if (tmp[0].equals("D")) {
                if (!pq1.isEmpty()) {
                    if (tmp[1].equals("1")) {
                        int delete = pq2.peek();
                        pq1.remove(delete);
                        pq2.remove(delete);
                        System.out.print(delete + " ");
                    } else {
                        int delete = pq1.peek();
                        pq1.remove(delete);
                        pq2.remove(delete);
                        System.out.print(delete + " ");
                    }
                }
            }
        }
        if (!pq1.isEmpty()) {
            answer[1] = pq1.peek();
            answer[0] = pq2.peek();
        }

        return answer;
    }
}
