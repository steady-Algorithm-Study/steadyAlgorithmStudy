package refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11657_bellman {
    static final int INF=987654321;
    static class Edge{
        int s;
        int e;
        int cost;

        Edge(int s, int e, int cost) {
            this.s=s;
            this.e= e;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        long [] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        //시작점
        dist[1]=0;

        ArrayList<Edge> graph = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Edge(s, e, c));
        }

        //벨만 포드
        //모든 정점개수-1 만큼 탐색
        for (int i = 1; i <= n; i++) {
            //간선의 개수만큼 반복
            for (int j = 0; j < m; j++) {
                //현재 간선에서 최소거리 갱신
                Edge edge=graph.get(j);
                if (dist[edge.s] != INF && dist[edge.e] > dist[edge.s] + edge.cost) {
                    dist[edge.e] = dist[edge.s] + edge.cost;
                }
            }
        }

        //음수 사이클 확인
        for (int j = 0; j < m; j++) {
            Edge edge=graph.get(j);
            //n번 째 탐색 시 갱신되는 값이 있는지 확인
            if (dist[edge.s] != INF && dist[edge.e] > dist[edge.s] + edge.cost) {
                System.out.println(-1);
                return;
            }
        }

        for(int i=2;i<=n;i++){
            //경로가 없을 경우
            if (dist[i] == INF) System.out.println(-1);
            else System.out.println(dist[i]);
        }


    }
}
