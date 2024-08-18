package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1068 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int root;
    static int end;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new List[N];
        visited = new boolean[N];
        for(int i = 0; i< N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i< N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == -1 ){
                root = i;
                continue;
            }
            list[a].add(i);
            list[i].add(a);
        }
        end = Integer.parseInt(br.readLine());
        DFS(root);


        System.out.println(count);


    }

    static void DFS(int x){
        visited[x] = true;
        int num = 0;
        for (Integer i : list[x]) {
            if(!visited[i] && i != end){
                num++;
                DFS(i);
            }
        }
        if( num == 0 ) count++;
    }



}
