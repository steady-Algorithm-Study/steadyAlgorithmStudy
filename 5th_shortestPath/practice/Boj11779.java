package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11779 {
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static int[] distance;
    static int INF = Integer.MAX_VALUE;
    static int[] visitCity;
    static int start,end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        visitCity = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 1; i<= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i< M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(distance[end]);
        find();


    }

    private static void find() {
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while(visitCity[end] != 0){
            cnt++;
            stack.push(visitCity[end]);
            end = visitCity[end];
        }
        System.out.println(cnt + 1);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node poll = pq.poll();
            int pv = poll.vertex;
            if(visited[pv]) continue;
            visited[pv] = true;
            for (Node node : list[pv]) {
                int vertex = node.vertex;
                int value = node.value;
                if(distance[vertex] > distance[pv]+value){
                    distance[vertex] = distance[pv] + value;
                    visitCity[vertex] = pv;
                    pq.add(new Node(vertex, distance[vertex]));
                }
            }
        }
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
