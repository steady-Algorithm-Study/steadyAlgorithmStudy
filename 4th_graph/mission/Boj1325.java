import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1325 {
    static int N, M, maxVal;
    static boolean[] visited;
    static int[] ans;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b].add(a);
        }

        maxVal = 0;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
            if (ans[i] > maxVal) maxVal = ans[i];
        }

        for (int i = 1; i <= N; i++) {
            if (ans[i] == maxVal) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void BFS(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int t = q.poll();

            for (int i : arr[t]) {
                if (!visited[i]) {
                    visited[i] = true;
                    ans[startNode]++;
                    q.add(i);
                }
            }
        }
    }
}
