package programmers;

public class Pg12985 {

    public static void main(String[] args) {
        Solution12985 solution12985 = new Solution12985();
        System.out.println(solution12985.solution(8,2,7));
    }
}

class Solution12985
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a!=b){
            a = a/2+a%2;
            b = b/2+b%2;
            answer++;
            System.out.println(answer);
        }

        return answer;
    }
}
