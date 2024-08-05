package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1753 {

    static int V,E,K;
    public static int[] distance;
    public static boolean[] visited;
    public static ArrayList<Edge>[] list;
    public static PriorityQueue<Edge> q = new PriorityQueue<Edge>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        visited = new boolean[V+1];
        distance = new  int[V+1];
        list = new ArrayList[V+1];
        for(int i = 1; i<= V; i++){
            list[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<= V; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i< E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v,w));
        }

        q.add(new Edge(K,0));
        distance[K] = 0;
        while(!q.isEmpty()){
            Edge poll = q.poll();
            int vertex = poll.vertex;
            if(visited[vertex]) continue;
            visited[vertex] = true;

            for (Edge edge : list[vertex]) {
                int next = edge.vertex;
                int value = edge.value;
                if(distance[next] > distance[vertex] + value){
                    distance[next] = distance[vertex] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }

        }

        for(int i = 1; i<= V; i++){
            if(visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }

    }

    static class Edge implements Comparable<Edge>{

        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.value > o.value) return 1;
            else return -1;
        }
    }
}
