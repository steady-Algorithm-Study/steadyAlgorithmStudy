import java.util.*;

class Solution {
    
    int INF = 200 * 100000 + 1;
    List<List<Edge>> graph;
    
    class Edge implements Comparable<Edge>{
        int end;
        int w;
        
        public Edge(int end, int w){
            this.end = end;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.w - e.w;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        int[] dist = new int[n + 1];
        int[] aPath = new int[n + 1];
        int[] bPath = new int[n + 1];
        
        Arrays.fill(dist, INF);
        Arrays.fill(aPath, INF);
        Arrays.fill(bPath, INF);
        
        int m = fares.length;
        
        for(int i = 0; i < m; i++){
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int w = fares[i][2];
            
            graph.get(v1).add(new Edge(v2, w));
            graph.get(v2).add(new Edge(v1, w));
        }
        
        dist = dijkstra(s, dist);
        aPath = dijkstra(a, aPath);
        bPath = dijkstra(b, bPath);
        
        int answer = INF;
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, dist[i] + aPath[i] + bPath[i]);
        } 
        
        return answer;
    }
    
    public int[] dijkstra(int s, int[] dist){
        dist[s] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.add(new Edge(s, 0));
        
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int curr = edge.end;
            int w = edge.w;
            
            if(w > dist[curr]){
                continue;
            }
            
            for(Edge e : graph.get(curr)){
                if(dist[e.end] > dist[curr] + e.w){
                    dist[e.end] = dist[curr] + e.w;
                    pq.add(new Edge(e.end, dist[e.end]));   
                }
            }
        }
        
        return dist;
    }
}