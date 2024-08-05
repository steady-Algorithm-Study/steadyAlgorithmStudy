package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1753_prac {
    static int V,E,K;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] list;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        visited = new boolean[V+1];
        result = new int[V+1];
        for(int i = 1; i <=V; i++){
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i< E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,w));
        }

        pq.add(new Node(K, 0));
        result[K] = 0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int vertex = poll.vertex;
            int value = poll.value;
            visited[vertex] = true;
            for (Node node : list[vertex]) {
                if(result[node.vertex] > result[vertex] + node.value){
                    result[node.vertex] = result[vertex] + node.value;
                    pq.add(new Node(node.vertex, result[node.vertex]));
                }
            }
        }
        for(int i = 1; i<=V; i++)
            if(visited[i]) System.out.println(result[i]);
            else System.out.println("INF");
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


