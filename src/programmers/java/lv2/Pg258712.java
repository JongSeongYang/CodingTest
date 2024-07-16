package programmers.java.lv2;

import java.util.*;

// 가장 많이 받은 선물

public class Pg258712 {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        String friend = "";
        HashMap<String, Integer> mapping = new HashMap<>();
        int[] g = new int[friends.length];
        int[][] arr = new int[friends.length][friends.length];

        for(int i = 0; i<friends.length; i++){
            mapping.put(friends[i], i);
        }

        for(int i = 0; i<gifts.length; i++) {
            String[] tmp = gifts[i].split(" ");
            int give = mapping.get(tmp[0]);
            int recieve = mapping.get(tmp[1]);
            arr[give][recieve]++;
            g[give]++;
            g[recieve]--;
        }

        for(int i = 0; i<friends.length; i++) {
            int num = 0;
            for(int j = 0;j<friends.length; j++) {
                if(i == j) continue;
                if(arr[i][j] > arr[j][i] || (arr[i][j] == arr[j][i] && g[i]>g[j])) num ++;

            }
            if(answer < num) answer = num;
        }
        return answer;
    }
}
