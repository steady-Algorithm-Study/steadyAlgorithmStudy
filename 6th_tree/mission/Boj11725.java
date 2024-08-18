package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11725 {

    static int N;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N+1];
        parent = new int[N+1];
        for(int i = 1; i<= N; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        DFS(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i< parent.length; i++){
            sb.append(parent[i] + "\n");
        }
        System.out.println(sb);
    }

    static void DFS(int x){
        visited[x] = true;

        for(int i : list[x]){
            if(!visited[i]){
                parent[i] = x;
                DFS(i);
            }
        }
    }
}
