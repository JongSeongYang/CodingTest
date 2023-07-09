package programmers.java.lv1;
import java.util.*;
/*
오픈채팅방
 */
public class Pg42888 {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for(int i = 0;i<record.length;i++){
            String[] tmp = record[i].split(" ");
            if(tmp.length == 3)
                map.put(tmp[1],tmp[2]);
        }
        for(int i = 0; i<record.length;i++){
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Enter")){
                list.add(map.get(tmp[1])+"님이 들어왔습니다.");
            }
            else if(tmp[0].equals("Leave")){
                list.add(map.get(tmp[1])+"님이 나갔습니다.");
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
