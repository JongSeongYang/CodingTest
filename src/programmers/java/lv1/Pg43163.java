package programmers.java.lv1;
import java.util.*;
/*
단어 변환
 */
public class Pg43163 {
    static int[][] table;
    static boolean[] visit;
    static ArrayList<char[]> c = new ArrayList<>();
    static int arrive = -1;
    static int answer = 10;
    static boolean check;
    public int solution(String begin, String target, String[] words) {

        table  = new int[words.length+1][words.length+1];
        visit = new boolean[words.length+1];
        c.add(begin.toCharArray());

        for(int i = 0;i<words.length;i++){
            if(words[i].equals(target))
                arrive = i+1;
            char[] arrChar = words[i].toCharArray();
            c.add(arrChar);
        }
        if(arrive == -1) return 0;
        System.out.println(arrive);

        for(int i = 0;i<c.size()-1;i++){
            for(int j = i+1;j<c.size();j++){
                if(check(c.get(i), c.get(j))){
                    table[i][j] =1;
                    table[j][i] =1;
                }
            }
        }
        for(int i = 0;i<c.size();i++){
            for(int j = 0;j<c.size();j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }
        visit[0] = true;
        dfs(0,0);
        if(!check) return 0;
        else return answer;
    }
    static void dfs(int node, int num){

        System.out.println(node+" "+ num);
        if(node == arrive){
            check = true;
            answer = Math.min(answer,num);
        }
        else{
            for(int i = 0;i<table.length;i++){
                if(table[node][i] == 1 && !visit[i]){
                    visit[i] = true;
                    dfs(i, num+1);
                    visit[i] = false;
                }
            }
        }
    }

    static boolean check(char[] a, char[] b){
        int dif = 0;
        for(int i = 0;i<a.length;i++){
            if(a[i]!=b[i])
                dif++;
        }
        if(dif<=1) return true;
        else return false;
    }
}
