package programmers.java.lv1;
/*
마법의 엘리베이터
 */
public class Pg148653 {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int rest = storey % 10;
            storey /= 10;
            // 남은 층 수가 5보다 크면 층을 올라가기
            // 남은 층이 5이고 다음 자리 수가 5보다 크거나 같으면 올라가기
            if((rest > 5) || (rest == 5 && (storey % 10) >= 5)) {
                rest = 10 - rest;
                storey ++;
            }
            // 남은 층 수가 5보다 작으면 내려가기
            answer += rest;
        }
        return answer;
    }
}

