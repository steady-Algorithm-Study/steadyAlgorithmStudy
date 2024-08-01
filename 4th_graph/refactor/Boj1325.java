package refactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1325 {
        static int N, M;
       static ArrayList<Integer>[] list = new ArrayList[10001];
       static boolean[] visited = new boolean[10001];
       static int[] result = new int[10001];
       static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N ; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
        for(int i = 1; i <= N; i ++){
            visited = new boolean[10001];
            BFS(i);
        }
        for(int i = 1; i<= N; i++) {
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i =1; i<= N; i++){
            if(result[i] == max) sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }

   static void BFS(int i){
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            for (Integer num : list[poll]) {
                if(!visited[num]){
                    visited[num] = true;
                    result[num]++;
                    queue.offer(num);
                }
            }
        }
    }
}
