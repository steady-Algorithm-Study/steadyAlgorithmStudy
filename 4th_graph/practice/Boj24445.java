package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj24445 {
    static boolean[] visited;
    static int count;
    static ArrayList<Integer>[] list;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        list = new ArrayList[N + 1];
        result = new int[N + 1];
        for(int i = 1 ; i <= N; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=N; i ++){
            Collections.sort(list[i], Comparator.reverseOrder());
        }

        BFS(R);
        for(int i=1; i<= N; i ++){
            System.out.println(result[i]);
        }

    }

    static void BFS(int k){
        Queue<Integer> qe = new LinkedList<>();
        qe.offer(k);
        visited[k] = true;
        while (!qe.isEmpty()) {
            int i = qe.poll();
            count++;
            result[i] = count;
            for (Integer integer : list[i]) {
                if(!visited[integer]){
                    visited[integer] = true;
                    qe.offer(integer);
                }
            }
        }

    }

}
