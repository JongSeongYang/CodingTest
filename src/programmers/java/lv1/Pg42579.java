package programmers.java.lv1;
import java.util.*;
/*
베스트앨범
 */
public class Pg42579 {
    HashMap<String, Integer> g = new HashMap<>();
    ArrayList<Integer> answer = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        for(int i = 0;i<genres.length;i++){
            g.put(genres[i], g.getOrDefault(genres[i],0)+plays[i]);
        }
        ArrayList<String> keySets = new ArrayList<>(g.keySet());
        Collections.sort(keySets,(o1, o2) -> (g.get(o2).compareTo(g.get(o1))));

        for(String s : keySets){
            System.out.println(s);
            int first = 0;
            int second = 0;
            int Max = 0;
            for(int i = 0;i<plays.length;i++){
                if(s.equals(genres[i])){
                    if(Max<plays[i]){
                        Max = plays[i];
                        first = i;
                    }
                }
            }
            Max = -1;
            for(int i = 0;i<plays.length;i++){
                if(i!= first && s.equals(genres[i])){
                    if(Max<plays[i]){
                        Max = plays[i];
                        second = i;
                    }
                }
            }
            answer.add(first);
            System.out.println(first);
            if(Max!=-1) answer.add(second);
            System.out.println(second);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
