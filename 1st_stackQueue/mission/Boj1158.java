import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Boj1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        int[] ansArr = new int[N];
        int idx = 0;


        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while (!deque.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                deque.offer(deque.poll());
            }
            ansArr[idx] = deque.poll();
            idx++;
        }

        String ans = Arrays.toString(ansArr);
        ans = ans.replace("[", "<").replace("]" , ">");

        System.out.println(ans);
    }
}