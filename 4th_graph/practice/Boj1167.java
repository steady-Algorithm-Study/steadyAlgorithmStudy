package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1167 {

    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        distance = new int[V+1];
        for(int i = 1; i <= V; i ++){
            list[i] = new ArrayList<>();
        }
            StringTokenizer st;
        for(int i = 0; i < V; i ++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            while(true){
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                int b = Integer.parseInt(st.nextToken());
                list[index].add(new Node(a,b));
            }
        }
        visited = new boolean[V+1];
        BFS(1);
        int max = 1;
        for(int i = 2; i<= V; i++){
            if(distance[max] < distance[i])
                max = i;
        }

        distance = new int[V+1];
        visited = new boolean[V+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[V]);


    }

    static void BFS(int index){
        Queue<Integer> qe = new LinkedList<>();
        qe.offer(index);
        visited[index] = true;
        while(!qe.isEmpty()){
            int now_node = qe.poll();
            for (Node node : list[now_node]) {
                int e = node.e;
                int v = node.value;
                if(!visited[e]){
                    visited[e] = true;
                    qe.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }
    }


    static class Node{
        int e;
        int value;

        public Node(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }

}
