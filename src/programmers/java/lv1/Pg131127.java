package programmers.java.lv1;
import java.util.*;
/*
할인 행사
 */
public class Pg131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i<want.length;i++){
            map.put(want[i], number[i]);
        }
        int lastDay = 0;
        for(int i = 0; i <= discount.length-10;i++){
            // i+10 번째 과일 추가하기
            while(lastDay <i+10){
                if(map.containsKey(discount[lastDay]))
                    map.put(discount[lastDay], map.get(discount[lastDay])-1);
                lastDay++;
            }
            // 조건 체크
            if(check(map))
                answer++;
            // i 번째 과일 다시 제외하기
            if(lastDay < discount.length && map.containsKey(discount[i]))
                map.put(discount[i], map.get(discount[i])+1);
        }
        return answer;
    }
    static boolean check(Map<String, Integer> m){
        for(String key : m.keySet()){
            if(m.get(key) > 0)
                return false;
        }
        return true;
    }
}
