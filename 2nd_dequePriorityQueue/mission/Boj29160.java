import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj29160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] playerArr = new PriorityQueue[12];

        for (int i = 0; i < playerArr.length; i++) {
            playerArr[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            playerArr[P].add(W);
        }

        int sum = 0;

        while (K --> 0) {
            sum = 0;
            for (int i = 1; i < playerArr.length; i++) {
                if (!playerArr[i].isEmpty()){
                    int cur = playerArr[i].poll();
                    playerArr[i].add(Math.max(0, --cur));
                    sum += playerArr[i].peek();
                }
            }
        }

        System.out.println(sum);
    }

}
