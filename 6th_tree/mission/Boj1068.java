package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1068 {
    static ArrayList<Integer>[] list;
    static int count;
    static boolean[] visited;
    static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int root = 0;
        list = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N ; i++){
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == -1){
                root = i;
                continue;
            }
            list[a].add(i);
        }
        end = Integer.parseInt(br.readLine());
        if(end != root){
            DFS(root);
        }
        System.out.println(count);

    }


    static void DFS(int x){
        int chk = 0;
        visited[x] = true;
        for(int i : list[x]){
            if(!visited[i] && i != end) {
                chk++;
                DFS(i);
            }
        }

        if(chk == 0) count++;
    }
}
