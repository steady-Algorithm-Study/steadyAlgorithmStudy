package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class n1835 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = n; i >= 1; i--) {
            deque.addFirst(i);  // i번 카드를 덱의 맨 앞에 추가
            for (int j = 0; j < i; j++) {
                deque.addFirst(deque.pollLast());  // i번 만큼 뒤로 돌린다.
            }
        }

        for (int card : deque) {
            System.out.print(card + " ");
        }
    }
}
