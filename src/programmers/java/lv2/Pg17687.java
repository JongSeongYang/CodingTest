package programmers.java.lv2;

// [3차] n진수 게임

public class Pg17687 {
    public String solution(int n, int t, int m, int p) {

        StringBuffer str = new StringBuffer("0");
        int count = 0;

        while (str.length() < (t * m + p)) {
            StringBuffer byNum = new StringBuffer();
            int num = count++;

            while (num != 0) {
                if (num % n >= 10)
                    byNum.append(String.valueOf((char) (num % n + 55)));
                else
                    byNum.append(String.valueOf(num % n));

                num /= n;
            }

            str.append(byNum.reverse().toString());
        }
        String answer = "";

        for (int i = 0; i < t; i++)
            answer += String.valueOf(str.charAt(m * i + p - 1));

        return answer;
    }
}
