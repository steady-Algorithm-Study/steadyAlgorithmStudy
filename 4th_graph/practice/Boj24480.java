package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj24480 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count;
    static int[] result ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];
        count = 0;
        for(int i = 1 ; i <= N ; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i <= N; i ++){
            Collections.sort(list[i], Comparator.reverseOrder());
        }
        DFS(R);


        for(int i = 1 ; i <= N ; i ++) {
            System.out.println(result[i]);
        }

    }

    static void DFS(int start){
        if(visited[start]) return;
        count++;
        result[start] = count;
        visited[start] = true;
        for (Integer i : list[start]) {
            if(!visited[i]){
                DFS(i);
            }
        }



    }
}
