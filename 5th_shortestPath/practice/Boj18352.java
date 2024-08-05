package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18352 {
    static int N,M,K,X;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];
        for( int i =1; i<= N; i++){
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i< M; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        result[X] = 0;
        solution(X);
        ArrayList<Integer> resultList = new ArrayList<>();

        for(int i = 1; i<= N; i++){
            if(result[i] == K) resultList.add(i);
        }
        resultList.sort(Comparator.naturalOrder());
        if(resultList.isEmpty()) System.out.println(-1);
        for (Integer i : resultList) {
            System.out.println(i);
        }
    }

    static void solution(int x){
        Queue<Integer> qe = new LinkedList<>();
        qe.offer(x);
        visited[x] = true;

        while(!qe.isEmpty()){
            Integer poll = qe.poll();
            for (Integer i : list[poll]) {
                if(!visited[i]){
                    if(result[i] > result[poll]+1){
                        result[i] = result[poll]+1;
                        qe.offer(i);
                    }
                }
            }
        }
    }

}
