package programmers.java.lv3;

import java.util.*;

// 110 옮기기

public class Pg77886 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        String target = "110";

        for(int i=0;i<s.length;i++){
            Stack<Character> st = new Stack<Character>();
            int cnt = 0;
            for(int j=0;j<s[i].length();j++){
                st.push(s[i].charAt(j));

                if(st.size() < 3) continue;
                char a = st.pop();
                if(a != '0'){
                    st.push(a);
                    continue;
                }
                char b = st.pop();
                if(b != '1'){
                    st.push(b);
                    st.push(a);
                    continue;
                }
                char c = st.pop();
                if(c != '1'){
                    st.push(c);
                    st.push(b);
                    st.push(a);
                    continue;
                }
                cnt++;
            }

            StringBuilder sb = new StringBuilder();
            int pos = st.size();
            boolean find = false;

            while(!st.isEmpty()){
                char pop = st.pop();
                if(!find && pop == '1') pos--;
                if(pop == '0') find = true;
                sb.insert(0, pop);
            }

            for(int j=0;j<cnt;j++)
                sb.insert(pos, target);
            answer[i] = sb.toString();
        }

        return answer;
    }
}
