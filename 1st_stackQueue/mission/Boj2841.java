import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        HashMap<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new LinkedList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int tmp = 0;

            Deque<Integer> deque = map.get(num1);

            if (deque.isEmpty()) {
                deque.offer(num2);
                ans++;
                map.put(num1, deque);
                continue;
            }

            while (!deque.isEmpty() && deque.peekLast() > num2) {
                deque.pollLast();
                ans++;
            }

            if (deque.isEmpty()) {
                ans++;
                deque.offer(num2);
            } else {
                if (deque.peekLast() != num2) {
                    ans++;
                    deque.offer(num2);
                }
            }


            map.put(num1, deque);

        }

        System.out.println(ans);
    }
}