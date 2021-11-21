package programmers;

// 프로그래머스 입실퇴실

import java.util.*;
import java.util.stream.IntStream;

public class pg86048 {
    public static void main(String[] args) {
        Solution86048 solution = new Solution86048();
        int[] enter = new int[]{1, 4, 2, 3};
        int[] leave = new int[]{2, 1, 3, 4};
        int[] result = solution.solution(enter, leave);
        IntStream stream = Arrays.stream(result);
        stream.forEach(System.out::println);
    }
}

class Solution86048 {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        List<Integer> room = new ArrayList<>();
        int outIdx = 0;
        for (int i = 0; i < enter.length; i++) {
            room.add(enter[i]);
            for (int j = 0; j < room.size(); j++) {
                int person = room.get(j);
                if (enter[i] == person)
                    answer[person - 1] += room.size() - 1;
                else answer[person - 1]++;
            }
            while (outIdx < answer.length && room.contains(leave[outIdx])) {
                room.remove(Integer.valueOf(leave[outIdx]));
                outIdx++;
            }
        }
        return answer;
    }
}
