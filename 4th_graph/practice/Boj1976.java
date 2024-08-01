package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1976 {

    static ArrayList<Integer>[] list = new ArrayList[201];
    static boolean[] visited = new boolean[201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    list[i].add(j);
                }
            }
        }
        String result = "YES";
        String[] s = br.readLine().split(" ");
        BFS(Integer.parseInt(s[0]));
        for(int i = 1; i<s.length; i++){
            if(!visited[Integer.parseInt(s[i])]){
                result = "NO";
                break;
            }
        }
        System.out.println(result);

    }

    static void BFS(int start) {
        Queue<Integer> qe = new LinkedList();
        qe.offer(start);
        visited[start] = true;
        while(!qe.isEmpty()){
            Integer poll = qe.poll();
            for (Integer i : list[poll]) {
                if(!visited[i]){
                    visited[i] = true;
                    qe.offer(i);
                }
            }
        }


    }
}
