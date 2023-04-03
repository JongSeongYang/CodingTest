package programmers;

// 양과 늑대
public class Pg92343 {

    public static void main(String[] args) {

    }
}

class Solution92343 {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        int size = info.length;
        int[][] map = new int[size][size];
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }

        return answer;
    }
}
