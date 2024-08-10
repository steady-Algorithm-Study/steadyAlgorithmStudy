package refactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11657 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M ;
    static Edge[] list;
    static Long[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         distance = new Long[N+1];
        list = new Edge[M+1];

        Arrays.fill(distance,2147483647L);
         for(int i = 0; i< M; i ++){
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             int c = Integer.parseInt(st.nextToken());
             list[i] = new Edge(a,b,c);
         }
         distance[1] = 0L;
         for(int i = 1; i < N ; i++){
             for(int j = 0 ; j < M; j++){
                 Edge edge = list[j];
                 if(distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.value){
                     distance[edge.end] = distance[edge.start] + edge.value;
                 }
             }
         }

         boolean cycleChk = false;
         for(int j = 0 ; j < M ; j ++){
             Edge edge = list[j];
             if(distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.value){
                 cycleChk = true;
             }
         }
        StringBuilder sb = new StringBuilder();
         if(cycleChk){
             sb.append(-1);
         }else{
             for(int i = 2; i <= N; i++){
                 if(distance[i] == INF) sb.append("-1");
                 else sb.append(distance[i]);
                 sb.append("\n");
             }
         }
        System.out.println(sb);

    }
    static class Edge{
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
