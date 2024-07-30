package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13023 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean arive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        arive = false;
        list = new ArrayList[n];
        for(int i = 0; i < n; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i< n; i ++){
            visited = new boolean[n];
            DFS(i, 1);
            if(arive) break;
        }

        if(arive)  System.out.println("1");
            else System.out.println("0");


    }

    static void DFS(int num, int depth){
        if(depth == 5 || arive){
            arive = true;
            return;
        }
        visited[num] = true;
        for (int i : list[num]) {
            if(!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[num] = false;


    }
}
