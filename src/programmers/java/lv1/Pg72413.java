package programmers.java.lv1;
/*
합승 택시 요금
 */
public class Pg72413 {
    static int[][] f;
    int INF = 20000001;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 2147483647;
        f = new int[n][n];
        for(int i = 0;i<n;i++)
            for(int j = 0;j<n;j++){
                if(i==j)f[i][j] =0;
                else f[i][j] = INF;
            }
        for(int i = 0 ;i<fares.length;i++){
            f[fares[i][0]-1][fares[i][1]-1] = fares[i][2];
            f[fares[i][1]-1][fares[i][0]-1] = fares[i][2];
        }
        System.out.println(" ");
        floyd(n);
        for(int i = 0;i<n;i++)
            answer = Math.min(answer, f[s-1][i]+f[i][a-1]+f[i][b-1]);
        return answer;
    }

    static void floyd(int n){
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(f[i][j]>f[i][k]+f[k][j])
                        f[i][j] = f[i][k]+f[k][j];
                }
            }
        }
    }
}
