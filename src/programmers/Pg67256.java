package programmers;

public class Pg67256 {
}
class Solution67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int nowLeft = 10;
        int nowRight = 12;
        for(int number : numbers){
            if(number ==0) number = 11;
            if(number%3 == 1) {
                answer+="L";
                nowLeft = number;
            }
            else if(number%3 == 0) {
                answer+="R";
                nowRight = number;
            }
            else{
                int numY = (number-1)/3;
                int numX = (number-1)%3;
                int leftLength = Math.abs(numY-(nowLeft-1)/3) + Math.abs(numX-(nowLeft-1)%3);
                int rightLength = Math.abs(numY-(nowRight-1)/3) + Math.abs(numX-(nowRight-1)%3);
                if(leftLength>rightLength){
                    answer+="R";
                    nowRight = number;
                }
                else if(leftLength<rightLength){
                    answer+="L";
                    nowLeft = number;
                }
                else{
                    if(hand.equals("left")){
                        answer+="L";
                        nowLeft = number;
                    }
                    else {
                        answer+="R";
                        nowRight = number;
                    }
                }
            }
        }
        return answer;
    }
}
