package programmers.java.lv2;

import java.util.*;

// 도넛과 막대 그래프

public class Pg258711 {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> edgeNum = new HashMap<>();

        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            int[] s = edgeNum.getOrDefault(start, new int[2]);
            s[0] += 1;
            edgeNum.put(start, s);

            int[] e = edgeNum.getOrDefault(end, new int[2]);
            e[1] += 1;
            edgeNum.put(end, e);

            //System.out.println("start : "+ start + " [" + s[0] + "," + s[1] + "]");
            //System.out.println("end   : "+ end + " [" + e[0] + "," + e[1] + "]");
        }
        int[] answer = new int[4];
        for(Integer key : edgeNum.keySet()){
            //System.out.println(key + " " + edgeNum.get(key)[0] + ", " + edgeNum.get(key)[1]);

            int[] edge = edgeNum.get(key);
            if(edge[0] >= 2 && edge[1] == 0) {
                answer[0] = key;
            }
            else if(edge[0] >= 2 && edge[1] >= 2) {
                answer[3]++;
            }
            else if(edge[0] == 0 && edge[1] >= 1) {
                answer[2]++;
            }
        }

        answer[1] = edgeNum.get(answer[0])[0] - answer[2] - answer[3];

        return answer;
    }
}
