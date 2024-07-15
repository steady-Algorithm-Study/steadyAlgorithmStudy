package study;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 프로세스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        int n = sc.nextInt();
        char p = str[n - 1];
        int answer = 0;
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i = 0; i < str.length; i++) {
            pq.offer(str[i]);
        }
        while (pq.peek() != p) {
            pq.poll();
            answer++;
        }
        System.out.println(++answer);


    }
}
