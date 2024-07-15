package study;

import java.util.PriorityQueue;
import java.util.Scanner;

public class n11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            if (num == 0) {
                answer.append(pq.size() == 0 ? 0 : pq.poll()).append("\n");
            } else pq.add(num);
        }
        System.out.println(answer.toString());


    }
}
