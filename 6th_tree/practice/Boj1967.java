import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1967 {

    static class Node{
        int child;
        int w;

        public Node(int child, int w){
            this.child = child;
            this.w = w;
        }
    }

    static List<List<Node>> tree;
    static int[] dist;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        dist = new int[N + 1];

        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree.get(start).add(new Node(end, w));
            tree.get(end).add(new Node(start, w));
        }

        Arrays.fill(dist, -1);

        dist[1] = 0;
        max = 0;

        dfs(1, 0, N);

        int maxIdx = -1;

        for(int i = 1; i <= N; i++){
            if(max == dist[i]){
                maxIdx = i;
            }
        }

        Arrays.fill(dist, -1);

        dist[maxIdx] = 0;
        max = 0;
        dfs(maxIdx, 0, N);

        System.out.println(max);
    }

    public static void dfs(int start, int w, int N){
        for(Node node : tree.get(start)){
            if(dist[node.child] == -1){
                dist[node.child] = node.w + w;
                max = Math.max(max, dist[node.child]);
                dfs(node.child, dist[node.child], N);
            }
        }
    }
}
