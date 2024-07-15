package study;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class n19638 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int h=sc.nextInt();
        int t = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < s; i++) {
            pq.offer(sc.nextInt());
        }
        String answer = "YES";
        int p = 0;
        for (int i = 0; i < t; i++) {
           if(pq.peek() >= h){
               pq.offer(pq.poll()/2);
               p++;
           }else break;
        }
        if(pq.peek() >= h){
            answer = "NO";
            p = pq.poll();
        }
        System.out.println(answer+"\n"+p);

    }
}
