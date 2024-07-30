package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {

    static ArrayList<Integer> list[] ;
    static boolean[] visited;
    static StringBuilder dfsSb;
    static StringBuilder bfsSb;
    static Queue<Integer> qe;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dfsSb = new StringBuilder();
        bfsSb = new StringBuilder();
        qe = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i <= n;  i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 1; i<= n; i++){
            Collections.sort(list[i]);

        }
        DFS(v);
        visited = new boolean[n+1];
        BFS(v);
        System.out.println(dfsSb.toString().trim() + "\n" + bfsSb.toString().trim());

    }

    static void DFS(int v){

        if(visited[v]) return;
        dfsSb.append(v + " ");
        visited[v] = true;
        for (Integer i : list[v]) {

            if(!visited[i]){
                DFS(i);
            }
        }
    }

    static void BFS(int v){
        if(visited[v]) return;

        visited[v] = true;
        bfsSb.append(v + " ");
        qe.add(v);
        while (!qe.isEmpty()) {

            for (Integer i : list[v]) {
                if(!visited[i])
                    qe.add(i);
            }
            BFS(qe.poll());
        }



    }
}
