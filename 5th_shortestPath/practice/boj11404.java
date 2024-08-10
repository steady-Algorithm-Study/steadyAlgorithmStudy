package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11404 {
    static final int INF=987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = INF;
            }
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[a][b] = v;
        }
        //플로이드 워샬
        for (int k = 1; k <= n ; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i==j) graph[i][j]=0;
                    Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
