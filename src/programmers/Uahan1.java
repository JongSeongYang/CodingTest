package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Uahan1 {
    public static void main(String[] args) {

    }
}

class Solution1 {
    public int[] solution(int[] arr) {
        int[] answer = new int[3];
        int[] numArr = new int[3];
        for(int i : arr){
            if(i == 1) numArr[0]++;
            else if(i == 2) numArr[1]++;
            else numArr[2]++;
        }
        int maxNum = Math.max(numArr[0], Math.max(numArr[1],numArr[2]));
        for(int i = 0;i<3;i++)
            answer[i] = maxNum-numArr[i];
        return answer;
    }
}

class Solution2 {
    public String solution(String[] log) {
        String answer = "";
        int[] time = new int[log.length];
        int sTime = 0;

        for (int i = 0; i < log.length; i++) {
            String[] tmp = log[i].split(":");
            time[i] = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
        }
        for (int i = 0; i < log.length - 1; i+=2) {
            if (time[i + 1] - time[i] < 5) continue;
            else sTime += Math.min(time[i + 1] - time[i], 105);
        }
        answer = sTime / 60 + ":" + sTime % 60;
        if (answer.length() == 4) answer = "0" + answer;

        return answer;
    }
}

class Solution3 {
    public int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        Map<String, Integer> mapIngs = new HashMap<>();
        Map<String, Integer> mapMargin = new HashMap<>();
        for(String ing : ings){
            String[] tmp = ing.split(" ");
            mapIngs.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        for(String m : menu) {
            String[] tmp = m.split(" ");
            int costIngs = 0;
            for (int i = 0; i < tmp[1].length(); i++) {
                costIngs += mapIngs.get(Character.toString(tmp[1].charAt(i)));
            }
            mapMargin.put(tmp[0], Integer.parseInt(tmp[2]) - costIngs);
        }

        for(String s: sell){
            String[] tmp = s.split(" ");
            int margin = mapMargin.get(tmp[0]);
            int num = Integer.parseInt(tmp[1]);
            answer += margin*num;
        }
        return answer;
    }
}

class Solution4 {
    public int[] solution(String s) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            } else {
                list.add(1);
            }
            if (i == s.length() - 1) {
                if (s.charAt(i) == s.charAt(0)) {
                    list.set(0, list.get(0) + list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                }
            }
        }
        Collections.sort(list);
        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}

class Solution5 {
    static int preNum;
    static int[][] answer;
    static int[][] visit;
    static int R;
    static int C;
    static int nowR;
    static int nowC;
    static int zeroNum;
    static boolean isEnd = false;
    public int[][] solution(int rows, int columns) {
        preNum = 1;
        zeroNum = rows*columns-1;
        R = rows;
        C = columns;
        nowR = 0;
        nowC = 0;
        answer = new int[rows][columns];
        visit = new int[rows][columns];
        answer[0][0] = 1;
        visit[0][0] = 1;
        while(true){
            if(zeroNum <= 0) break;
            if(isEnd) break;
            move();
        }

        return answer;
    }

    public static void move(){
        int nextC = nowC;
        int nextR = nowR;
        if(preNum%2==0) nextR++;
        else nextC++;

        if(nextR==R) nextR = 0;
        if(nextC==C) nextC = 0;

        if(R == C){
            if(visit[nextR][nextC] == 1){
                isEnd = true;
                return;
            }
        }
        nowR = nextR;
        nowC = nextC;
        answer[nextR][nextC] = ++preNum;
        if(visit[nextR][nextC] == 0){
            visit[nextR][nextC] = 1;
            zeroNum--;
        }
    }
}

class Solution6 {
    public String solution(double time, String[][] plans) {
        String answer = "";

        for (String[] plan : plans) {

            double start = convertTime(plan[1]);
            double end = convertTime(plan[2]);

            double startVacation = 18.0 - start;
            if (startVacation > 0) time -= startVacation;

            double endVacation = end - 9.5;
            if (endVacation > 0) time -= endVacation;

            if(time >= 0) answer = plan[0];
        }

        return answer;
    }
    static public double convertTime(String time){
        if (time.charAt(time.length() - 2) == 'P') {
            return Double.parseDouble(time.substring(0, time.length() - 2)) + 12.0;
        } else {
            return Double.parseDouble(time.substring(0, time.length() - 2));
        }
    }
}

class Solution7 {
    static String[] answer;
    static int len;
    public String[] solution(String[] grid, boolean clockwise) {
        len = grid.length;
        answer = new String[len];
        if (clockwise)
            clockTrue(grid);
        else
            clockFalse(grid);
        return answer;
    }

    static public void clockTrue(String[] grid){
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = len - 1; j >= len - i - 1; j--) {
                if (j == len - i - 1) {
                    sb.append(grid[j], 0, 1);
                    grid[j] = grid[j].substring(1);
                } else {
                    for (int k = 1; k >= 0; k--)
                        sb.append(grid[j].charAt(k));
                    grid[j] = grid[j].substring(2);
                }
            }
            answer[i] = sb.toString();
        }
    }

    static public void clockFalse(String[] grid){
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = len - i - 1; j <= len - 1; j++) {
                int subLen = grid[j].length();
                if (j == len - i - 1) {
                    sb.append(grid[j], subLen - 1, subLen);
                    grid[j] = grid[j].substring(0, subLen - 1);
                } else {
                    for (int k = subLen - 1; k >= subLen - 2; k--)
                        sb.append(grid[j].charAt(k));
                    grid[j] = grid[j].substring(0, subLen - 2);
                }
            }
            answer[i] = sb.toString();
        }
    }
}

