package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11657 {
    static int[][] distance;
    static boolean[] visited;
    static int N,M;
    static int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 1; i<= N; i++){
            for(int j = 1; j<= N; j++){
                if(i ==j) continue;
                distance[i][j] = INF;
            }
        }

        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = Math.min(distance[a][b], c);
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j<= N; j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // 이곳은 음수인
        boolean chk = false;
        for(int i = 1; i <= N; i++){
            if(distance[i][i] < 0) chk = true;
        }

            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) {
                if (distance[1][i] == INF && chk) sb.append(-1);
                else if (distance[1][i] < 0) {
                    sb.append("-1");
                } else sb.append(distance[1][i]);
                sb.append("\n");
            }
            System.out.println(sb);
    }


}
