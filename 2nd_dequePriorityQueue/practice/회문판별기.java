package study;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 회문판별기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : arr) {
            deque.offer(c);
        }

        String answer = "YES";
        int front = arr.length - 1, rear = 0;
        while (front > rear) {
            if (deque.poll() != deque.pollLast()) {
                answer = "NO";
                break;
            }front--;
            rear++;
        }
        System.out.println(answer);

    }
}
