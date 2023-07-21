package programmers.java.lv1;
import java.util.*;
/*
롤케이크 자르기
 */
public class Pg132265 {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> one = new HashSet<>();
        Map<Integer, Integer> two = new HashMap<>();
        one.add(topping[0]);
        for(int i = 1;i<topping.length;i++){
            two.put(topping[i], two.getOrDefault(topping[i], 0) + 1);
        }
        for(int i = 1;i<topping.length-1;i++){
            one.add(topping[i]);
            two.put(topping[i], two.get(topping[i]) - 1);
            // 뒷부분에 같은 숫자가 없으면 제거
            if(two.get(topping[i]) == 0)
                two.remove(topping[i]);

            if(one.size() == two.size())
                answer++;

        }
        return answer;
    }
}
