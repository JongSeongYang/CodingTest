package programmers.java.lv1;
import java.util.*;
/*
귤 고르기
 */
public class Pg138476 {
    static class Info {
        private int index;
        private int num;

        Info(int index, int num){
            this.index = index;
            this.num = num;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 과일의 개수를 세서 종류별로 개수를 기준으로 내림차순으로 정렬
        PriorityQueue<Info> pq = new PriorityQueue<>(
                (o1, o2) -> o2.num - o1.num
        );
        Arrays.sort(tangerine);
        int idx = 0;
        int n = 0;
        int cnt = 0;
        while(n < tangerine.length){
            // idx 가 바뀌면 pq에 저장
            if(idx != tangerine[n]){
                if(idx != 0){
                    pq.offer(new Info(idx, cnt));
                    cnt = 0;
                }
                idx = tangerine[n];
            }
            cnt++;
            n++;
        }
        // 마지막 cnt pq에 저장
        pq.offer(new Info(idx, cnt));
        int tNum = k;
        while(!pq.isEmpty() && tNum > 0){
            Info info = pq.poll();
            // k 보다 많거나 같은 개수가 있으면 1종류로 가능
            if(info.num >= k)
                return 1;
                // 과일을 담으면 남은 자리수를 줄임
                // 남은 자리보다 과일의 개수가 많아도 상관없음(1종류가 되므로)
            else{
                tNum -= info.num;
                answer ++;
            }
        }
        return answer;
    }
}
