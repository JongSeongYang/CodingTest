package programmers.java.lv1;
import java.util.*;
/*
이모티콘 할인행사
 */
public class Pg150368 {
    static int[] discount = new int[]{40, 30, 20, 10};
    static int plusNum = 0;
    static int totalMoney = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> discountEmo = new ArrayList<>();
        permutation(arr, emoticons.length, users, emoticons, discountEmo);
        return new int[]{plusNum, totalMoney};
    }

    static void permutation(ArrayList<Integer> arr, int cnt, int[][] users
            , int[] emoticons, ArrayList<Integer> discountEmo){
        // 할인율 순열을 다 만들었으면
        if (cnt == 0) {
            int plus = 0;
            int money = 0;
            // 사용자마다 비교
            for(int j = 0;j<users.length;j++){
                int sum = 0;
                int isPlus = 0;
                for(int k = 0;k<discountEmo.size();k++){
                    // 구매할인율보다 크게 할인하면
                    if(users[j][0] <= arr.get(k))
                        sum += discountEmo.get(k);
                    // 만약 구매비용이 플러스 구매비용보다 크다면
                    // 더이상 구매 안하고 플러스 구매
                    if(sum >= users[j][1]){
                        isPlus = 1;
                        break;
                    }
                }
                // 플러스 구매했으니 모든 구매 취소
                if(isPlus==1)
                    sum = 0;
                plus += isPlus;
                money += sum;
            }
            // 기존 플러스 구매자수와 수익과 비교
            if(plusNum < plus){
                plusNum = plus;
                totalMoney = money;
            } else if(plusNum == plus)
                totalMoney = Math.max(totalMoney, money);
            return;
        }
        // 할인율 순열과 할인된 가격을 계산
        for(int i = 0; i < 4; i++) {
            arr.add(discount[i]);
            discountEmo.add((int)emoticons[cnt-1]*(100-discount[i])/100);
            permutation(arr, cnt - 1, users, emoticons,discountEmo);
            arr.remove(arr.size() - 1);
            discountEmo.remove(discountEmo.size()-1);
        }
    }
}
