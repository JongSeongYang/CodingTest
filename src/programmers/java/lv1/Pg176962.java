package programmers.java.lv1;
import java.util.*;
/*
과제 진행하기
 */
public class Pg176962 {
    static class Task {
        private String name;
        private int start;
        private int playTime;

        Task(String name, int start, int playTime){
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        Task(String name, int playTime){
            this.name = name;
            this.playTime = playTime;
        }
    }
    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        PriorityQueue<Task> pq = new PriorityQueue<>(
                (o1, o2) -> (o1.start - o2.start));
        Stack<Task> s = new Stack<>();
        for(String[] plan : plans){
            String[] tmp = plan[1].split(":");
            int start = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
            pq.offer(new Task(plan[0], start, Integer.parseInt(plan[2])));
        }
        int nowTime = 0;
        while(!pq.isEmpty()){
            Task nowTask = pq.poll();
            String nowTaskName = nowTask.name;
            Integer nowTaskStart = nowTask.start;
            Integer nowTaskPlayTime = nowTask.playTime;
            nowTime = nowTaskStart;
            if(!pq.isEmpty()){
                Task nextTask = pq.peek();
                String nextTaskName = nextTask.name;
                Integer nextTaskStart = nextTask.start;
                Integer nextTaskPlayTime = nextTask.playTime;
                // 기존 과제를 새로운 과제 전에 딱 맞춰 다 끝냈을 경우
                if(nowTaskStart + nowTaskPlayTime == nextTaskStart){
                    answer.add(nowTaskName);
                    continue;
                }
                // 기존 과제를 새로운 과제 전에 다 끝내고 시간이 남을 경우
                else if(nowTaskStart + nowTaskPlayTime < nextTaskStart){
                    answer.add(nowTaskName);
                    nowTime += nowTaskPlayTime;
                    while(!s.isEmpty()){
                        Task remainTask = s.pop();
                        String remainTaskName = remainTask.name;
                        Integer remainTaskPlayTime = remainTask.playTime;
                        // 남은 과제를 다 끝내지 못했으면
                        if(nowTime + remainTaskPlayTime > nextTaskStart){
                            s.push(new Task(remainTaskName, nowTime + remainTaskPlayTime - nextTaskStart));
                            break;
                        }
                        // 남은과제를 다끝냈으면
                        else{
                            nowTime += remainTaskPlayTime;
                            answer.add(remainTaskName);
                            continue;
                        }
                    }

                }
                // 새로운 과제를 시작전까지 다 못끝낸 경우
                else{
                    s.push(new Task(nowTaskName, nowTaskPlayTime + nowTime - nextTaskStart));
                }
            }
            // 더이상 남은 과제가 없는 경우
            else {
                answer.add(nowTaskName);
                // 남아있는 과제도 없는 경우
                if(s.isEmpty()){
                    nowTime += nowTaskPlayTime;
                }
                // 남아있는 과제가 있으면
                else {
                    while(!s.isEmpty()){
                        Task remainTask = s.pop();
                        answer.add(remainTask.name);
                    }
                }
            }
        }

        return answer.toArray(new String[answer.size()]);
    }
}
