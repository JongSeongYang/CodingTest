package programmers.java.lv1;
import java.util.*;
/*
디펜스 게임
 */
public class Pg142085 {
    public int solution(int n, int k, int[] enemy) {
        int round = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0;i< enemy.length; i++){
            // round 저장
            round++;
            // 무적권을 쓸 라운드의 적의 수를 저장
            if(p.size() < k)
                p.offer(enemy[i]);
                // 무적권을 다 썼다면
            else if(p.size() == k){
                // 무적권을 사용한 라운드의 병사중 가장 적은 수의 병사와 현재 라운드의 병사 비교
                int minQueue = p.poll();
                int e = enemy[i];
                // 큐의 최솟값 <현재 라운드의 적
                if(minQueue < e){
                    p.offer(e);
                    e = minQueue;
                }
                // 큐의 최솟값 >= 현재 라운드의 적
                else {
                    p.offer(minQueue);
                }
                // 현재 병사 >= 현재 라운드의 적
                if(n >= e)
                    n -= e;
                    // 현재 병사 < 현재 라운드의 적
                    // 라운드를 막지 못했으므로 round 감소
                else{
                    round --;
                    break;
                }
            }
        }
        return round;
    }
}
