import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11725 {
    static boolean[] visited;
    static ArrayList<Integer>[] e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] ansArr = new int[N + 1];
        e = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            e[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            e[a].add(b);
            e[b].add(a);
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int x = queue.pollFirst();

            for (int t : e[x]) {
                if (!visited[t]) {
                    ansArr[t] = x;
                    visited[t] = true;
                    queue.offer(t);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(ansArr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
