package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj11404_다익스트라 {
    static int N,M;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        result = new int[N+1];
        for(int i = 1; i<= N; i++){
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<M; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }

        for(int i = 1; i<= N; i ++) {
            visited = new boolean[N+1];
            result[i] = 0;
            pq.add(new Node(i, 0));
            solution();
        }

        System.out.println(sb);

    }

    static void  solution(){
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            int vertex = poll.vertex;
            if(visited[vertex]) continue;
            visited[vertex]= true;

            for (Node node : list[vertex]) {
                int t = node.vertex;
                int v = node.value;
                if(result[t] > result[vertex] + v){
                    result[t] = result[vertex] + v;
                    pq.add(new Node(t, result[t]));
                }
            }
        }
        for(int j = 1; j <= N; j++){
            if(result[j] == Integer.MAX_VALUE){
                sb.append(0 + " ");
            }else{
                sb.append(result[j] + " ");
            }
            result[j] = Integer.MAX_VALUE;
        }
        sb.append("\n");

    }
    static class Node implements Comparable<Node>{
        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value > o.value) return 1;
            else return -1;
        }
    }
}
