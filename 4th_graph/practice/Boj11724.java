package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.function.Function;

/**
 * 연결 요소의 개수
 */

public class Boj11724 {

    static ArrayList<Integer>[] arr;
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> fn = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = fn.apply(st.nextToken());
        int m = fn.apply(st.nextToken());


        arr = new ArrayList[n+1];
        for(int i = 1 ; i < n+1 ; i ++){
            arr[i] = new ArrayList();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int N = fn.apply(st.nextToken());
            int M = fn.apply(st.nextToken());
            arr[N].add(M);
            arr[M].add(N);

        }
        visited = new boolean[ n + 1];

        int count = 0;
        for(int i = 1; i < n+1; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println("count = " + count);


    }

    static void DFS(int v){
        if(visited[v])return;

        visited[v] = true;
        for(int i : arr[v]){
            if(visited[i] == false){
                DFS(i);
            }
        }
   }
}
