import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            taskQueue.add(new Task(d, w));
        }

        int day = 0;
        int ans = 0;

        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            if (task.day - day >= 0) {
                ans += task.weight;
            }
            day++;
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
            if (this.day == o.day) {
                return o.weight - this.weight;
            } else {
                return this.day - o.day;
            }
        }
    }
}
