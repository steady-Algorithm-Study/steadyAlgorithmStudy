import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11657_re {

    static final int INF = 100000000;
    static ArrayList<Edge> graph = new ArrayList<>();
    static long[] dist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Edge(v, w, cost));
        }

        if (!bf(1)) {
            System.out.println(-1);
        } else {
            for (int i = 2; i < dist.length; i++) {
                sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
            }
        };

        System.out.println(sb);
    }

    public static boolean bf(int start) {
        // 시작 노드에 대한 초기화
        dist[start] = 0;
        // 정점 개수만큼 반복
        for (int i = 0; i < N; i++) {
            // 매 반복마다 모든 간선 확인
            for (int j = 0; j < M; j++) {
                Edge edge = graph.get(j);

                // 현재 간선의 들어오는 정점에 대한 비교
                if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        // 음수 가중치 확인
        for (int i = 0; i < M; i++) {
            Edge edge = graph.get(i);

            if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                return false;
            }
        }

        return true;
    }

    static class Edge {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
}
