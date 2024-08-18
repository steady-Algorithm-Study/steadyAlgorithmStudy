package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11725 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];
        for(int i = 1; i<= N; i ++){
            list[i] = new ArrayList<>();

        }

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        DFS(1);

        for(int i =2 ; i<=N; i++){
            System.out.println(parent[i]);
        }

    }

    static void DFS(int x){
        visited[x] = true;

        for (Integer i : list[x]) {
            if(!visited[i]){
                parent[i] = x;
                DFS(i);
            }
        }

    }

}
