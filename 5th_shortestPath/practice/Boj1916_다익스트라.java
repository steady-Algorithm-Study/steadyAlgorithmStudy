package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1916_다익스트라 {

    static int N, M;
    static int INF = Integer.MAX_VALUE / 2;
    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        list = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        distance = new int[N+1];
        for (int i = 1; i <= N; i++) {
                distance[i] = INF;
        }
        for(int i = 0; i< M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> qe = new PriorityQueue<>();
        qe.add(new Node(x,0));
        distance[x] = 0;

        while(!qe.isEmpty()){
            Node poll = qe.poll();
            int pv = poll.vertex;
            if(!visited[pv]) {
                visited[pv] = true;
                for (Node node : list[pv]) {
                    int nv = node.vertex;
                    int value = node.value;
                    if (distance[nv] > poll.value)
                        distance[nv] = Math.min(distance[nv], distance[pv] + value);
                    qe.add(new Node(nv, distance[nv]));
                }
            }
        }
        System.out.println(distance[y]);
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
            return this.value - o.value;
        }
    }

  }
