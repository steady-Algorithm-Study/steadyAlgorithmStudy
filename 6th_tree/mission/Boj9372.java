import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Graph graph = new Graph(N, M);

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.edges[j] = new Edge(a, b);
            }

            graph.kruskal();
        }
    }

    static class Edge {

        int s, e;

        public Edge(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    static class Graph {
        int V, E;
        Edge[] edges;

        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
        }

        int find(int[] parent, int i) {
            if (parent[i] == -1) {
                return i;
            }
            return find(parent, parent[i]);
        }

        void union(int[] parent, int x, int y) {
            int xSet = find(parent, x);
            int ySet = find(parent, y);
            if (xSet != ySet) {
                parent[xSet] = ySet;
            }
        }

        void kruskal() {
            int e = 0;
            int i = 0;

            int[] parent = new int[V + 1];
            Arrays.fill(parent, -1);

            while (e < V - 1) {
                Edge next = edges[i++];
                int x = find(parent, next.s);
                int y = find(parent, next.e);

                if (x != y) {
                    e++;
                    union(parent, x, y);
                }
            }

            System.out.println(e);
        }
    }
}