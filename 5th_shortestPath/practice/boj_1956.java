package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_1956 {
    static final int INF=987654321;
    static int answer=0;
    public static void floyd(int[][] graph, int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i==j)continue;
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j]==INF) continue;
                //서로에게 가는 경로가 있다면 사이클이 존재한다
                if (graph[i][j] != INF && graph[i][j] != INF) {
                    answer = Math.min(answer, graph[i][j] + graph[j][i]);
                }
            }
        }
        answer=(answer==INF)?-1:answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v=Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] graph = new int[v + 1][v + 1];


        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(i==j) continue;
                graph[i][j] = INF;
            }
        }

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }

        //플로이드 알고리즘 수행
        floyd(graph, v);
        System.out.println(answer);
    }
}
