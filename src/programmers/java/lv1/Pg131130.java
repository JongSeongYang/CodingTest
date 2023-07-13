package programmers.java.lv1;
import java.util.*;
/*
혼자 놀기의 달인
 */
public class Pg131130 {
    static int answer = 0;
    static boolean[] check;
    public int solution(int[] cards) {
        check = new boolean[cards.length];
        ArrayList<Integer> arr = new ArrayList<>();
        int arrIdx = -1; // 그룹들의 개수를 모아놓은 리스트 크기 관리
        for(int i = 0;i<cards.length;i++){
            // 이미 방문했다면 skip
            if(check[i])
                continue;
            check[i] = true;
            // 새로운 그룹 생성
            arr.add(1);
            arrIdx++;
            int next = cards[i]-1;
            // 같은 그룹인 상자 찾기
            while(!check[next]){
                check[next] = true;
                arr.set(arrIdx, arr.get(arrIdx)+1);
                next = cards[next]-1;
            }
        }
        // 정렬 후 제일 큰 두개 곱해서 return
        // size = 1 이면 0 return
        Collections.sort(arr, Collections.reverseOrder());
        if(arrIdx == 0) return 0;
        return arr.get(0) * arr.get(1);
    }
}
