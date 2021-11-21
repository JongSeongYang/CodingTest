package programmers;

// 이진변환 반복하기

import java.util.Arrays;

public class Pg70129 {
    public static void main(String[] args) {
        Solution70129 solution70129 = new Solution70129();
        String s = "110010101001";
        System.out.println(Arrays.toString(solution70129.solution(s)));
    }
}

class Solution70129 {
    public int[] solution(String s) {
        int changeNum = 0;
        int zeroNum = 0;
        while(!s.equals("1")){
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)=='0')
                    zeroNum++;
            }
            s = s.replace("0","");
            s = Integer.toBinaryString(s.length());
            changeNum++;
        }
        return new int[]{changeNum,zeroNum};
    }
}
