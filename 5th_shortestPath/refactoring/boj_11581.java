package refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class boj_11581 {
    static int[] visited;
    static String answer="NO CYCLE";
    static ArrayList<ArrayList<Integer>> graph;
    static void dfs(int curr) {

        if (visited[curr] == -1) {
            answer = "CYCLE";
            return ;
        }

        visited[curr] = -1;

        for(int v:graph.get(curr)){
            if (visited[v] != 1) {
                dfs(v);
            }
        }
        visited[curr]=1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        visited=new int[n+1];

        for (int i = 1; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            for (String s : str) {
                graph.get(i).add(Integer.parseInt(s));
            }
        }
        dfs(1);

        //bfs가 안되는 이유 cycle 확인이 안됨
        /*//bfs
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        q.add(1);
        visited.add(1);
        while (!q.isEmpty()) {
            int size=q.size();
            for (int i = 0; i < size; i++) {
                int x=q.poll();
                for(int k:graph.get(x)) {
                    if(visited.contains(k)) {
                        System.out.println("CYCLE");
                        return ;
                    }else{
                        q.add(k);
                        visited.add(k);
                    }
                }
            }
        }
        System.out.println("NO CYCLE");*/

        System.out.println(answer);
    }
}
