package programmers;

// 위장

import java.util.HashMap;

public class Pg42578 {
    public static void main(String[] args) {
        Solution42578 solution42578 = new Solution42578();
    }

}
class Solution42578 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<clothes.length;i++){
            Integer a = map.get(clothes[i][1]);
            if(a == null) map.put(clothes[i][1], 1);
            else map.put(clothes[i][1],a+1);
        }
        for(String s : map.keySet()){
            answer*=(map.get(s)+1);
        }
        return answer-1;
    }
}