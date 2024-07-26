import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13904_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        PriorityQueue<Integer> weightQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            taskQueue.add(new Task(d, w));
        }

        int day = taskQueue.peek().day;
        int ans = 0;

        while (day > 0) {
            while (!taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                if (task.day >= day) {
                    weightQueue.offer(task.weight);
                } else {
                    taskQueue.offer(task);
                    break;
                }
            }

            if (!weightQueue.isEmpty()) {
                ans += weightQueue.poll();
            }

            day--;
        }

        System.out.println(ans);
    }

    static class Task implements Comparable<Task> {
        int day;
        int weight;

        Task (int day, int weight) {
            this.day = day;
            this.weight = weight;
        }

        @Override
        public int compareTo(Task o) {
            return this.day - o.day;
        }
    }
}
