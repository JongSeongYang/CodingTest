package programmers.java.lv1;
import java.util.*;
/*
택배상자
 */
public class Pg131704 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int num = order.length;
        int idx = 0;
        for(int box = 1; box<=num; box++){
            // 보조 컨테이너에 박스가 있으면
            while(!s.isEmpty()){
                int container = s.pop();
                // 보조 컨테이너에 있는 것이 순서에 맞는 상자일때
                if(container == order[idx]){
                    idx++;
                    answer++;
                }
                // 보조 컨테이너에 있는 것이 순서에 맞지 않는 상자일때
                // 다시 보조 컨테이너에 넣기
                else {
                    s.add(container);
                    break;
                }
            }
            // 벨트의 상자가 순서에 맞을때
            if(box == order[idx]){
                idx++;
                answer++;
            }
            // 벨트의 상자가 순서에 맞지 않으면 보조 컨테이너에 넣기
            else {
                s.add(box);
            }
        }
        // 벨트의 박스가 다 사용되면
        // 보조 컨테이너의 상자들이 순서에 맞는지 확인
        while(!s.isEmpty()){
            int container = s.pop();
            if(container != order[idx]){
                break;
            } else {
                answer++;
                idx++;
            }
        }
        return answer;
    }
}
