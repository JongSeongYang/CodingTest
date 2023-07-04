package programmers.java.lv1;

import java.util.*;
/*
호텔 대실
 */
public class Pg155651 {
    static class Book {
        private int start;
        private int end;

        public Book(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> room = new PriorityQueue<>();
        PriorityQueue<Book> pq = new PriorityQueue<>(
                (o1, o2) -> (o1.start - o2.start)
        );
        for(String[] book : book_time){
            String[] tmp1 = book[0].split(":");
            String[] tmp2 = book[1].split(":");
            int start = Integer.parseInt(tmp1[0])*60 + Integer.parseInt(tmp1[1]);
            int end = Integer.parseInt(tmp2[0])*60 + Integer.parseInt(tmp2[1]);
            pq.add(new Book(start, end));
        }
        room.add(0);
        int nowTime = 0;
        while(!pq.isEmpty()){
            Book newBook = pq.poll();
            nowTime = newBook.start;
            int fastRoomEnd = room.poll();
            // 빈 방이 없을 경우 방 추가
            if(fastRoomEnd > newBook.start){
                room.add(fastRoomEnd); // 가장 빨리 끝나는 방도 다시 넣어주기
                room.add(newBook.end + 10);
            } else {
                // 빈방이 있을 경우
                room.add(newBook.end + 10);
            }
        }
        return room.size();
    }
}
