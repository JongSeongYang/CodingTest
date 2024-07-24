package programmers.java.lv2;

// 피로도

public class Pg87946 {
    static int answer;
    static int[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new int[dungeons.length];
        func(k, 0, dungeons);

        return answer;
    }

    static void func(int nowHealth, int num, int[][] dungeons) {
        // System.out.println("[" + num + "] health : " + nowHealth);

        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] == 0 && nowHealth >= dungeons[i][0]) {
                visited[i] = 1;
                func(nowHealth-dungeons[i][1], num + 1, dungeons);
                visited[i] = 0;
            }
        }
        answer = Math.max(answer, num);
    }
}
