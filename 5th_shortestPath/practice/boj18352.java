package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m= Integer.parseInt(br.readLine());
        int k= Integer.parseInt(br.readLine());
        int x= Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int key= Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            graph.get(key).add(value);
        }

        Queue<Integer> q=new LinkedList<>();
        int L=0;
        while(L!=k){

        }
    }
}
