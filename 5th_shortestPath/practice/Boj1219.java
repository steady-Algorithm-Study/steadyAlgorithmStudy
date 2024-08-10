package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1219 {
    static int N,M, S,E ;
    static Edge[] edges ;
    static Long[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M+1];
        distance = new Long[N];
        Arrays.fill(distance,Long.MIN_VALUE);
        for(int i = 0 ; i < M; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a,b,c);
        }
        String[] s = br.readLine().split(" ");
        distance[S] = Long.parseLong(s[S]);

        for(int i = 0; i <= N + 100; i++){
            for(int j = 0; j < M; j++){
                Edge edge = edges[j];
                if(distance[edge.start] == Long.MIN_VALUE) continue;
                else if(distance[edge.start] == Long.MAX_VALUE ){
                    distance[edge.end] = Long.MAX_VALUE;
                }
                else if(distance[edge.end] < distance[edge.start] - edge.value  + Long.parseLong(s[edge.end]) ){
                    distance[edge.end] = distance[edge.start] - edge.value + Long.parseLong(s[edge.end]);

                    if ( i >= N - 1 ) distance[edge.end]  = Long.MAX_VALUE;
                }
            }
        }

      if(distance[E] == Long.MIN_VALUE){
          System.out.println("gg");
      } else if (distance[E] == Long.MAX_VALUE) {
          System.out.println("Gee");
      }else{
          System.out.println(distance[E]);
      }






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
