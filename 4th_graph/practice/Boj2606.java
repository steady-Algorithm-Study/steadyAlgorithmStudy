package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2606 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N ; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        DFS(1);
        System.out.println(count-1);


    }

    static void DFS(int start){
        if(visited[start]) return;

        visited[start] = true;
        count++;
        for (Integer i : list[start]) {
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
