import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11657 {
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            dist[A][B] = Math.min(C, dist[A][B]);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        if (dist[i][k] == INF || dist[k][j] == INF) continue;
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            if (dist[i][i] < 0) {
                flag = true;
                break;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (dist[1][i] != INF && flag) {
                System.out.println(-1);
                return;
            } else {
                sb.append(dist[1][i] == INF ? -1 : dist[1][i]).append("\n");
            }
        }
        System.out.println(sb);

    }
}
