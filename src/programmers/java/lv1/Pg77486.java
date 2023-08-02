package programmers.java.lv1;
import java.util.*;
/*
다단계 칫솔 판매
 */
public class Pg77486 {
    static Map<String, String> sonParent = new HashMap<>();
    static Map<String, Integer> memberIndex = new HashMap<>();
    static int[] money;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        for(int i=0; i < enroll.length; i++){
            sonParent.put(enroll[i], referral[i]);
            memberIndex.put(enroll[i], i);
        }
        money = new int[enroll.length];
        for(int i = 0;i<seller.length;i++){
            divideMoney(seller[i],amount[i],enroll,referral);
        }
        return money;
    }

    static void divideMoney(String seller, int amount, String[] enroll, String[] referral){
        String son = seller;
        String parent = sonParent.get(son);

        int gain = amount*100;
        while(true){
            int parentGain = gain/10;
            int myGain = gain - parentGain;
            gain = parentGain;
            money[memberIndex.get(son)] += myGain;
            if(parent.equals("-") || gain <1 ) break;
            son = parent;
            parent = sonParent.get(son);
        }
    }
}
