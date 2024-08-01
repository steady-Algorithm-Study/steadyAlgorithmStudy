import java.util.*;

/**
* 모든 정점을 다 접근해야 함
* 1 > 2, 2 > 3 ==> 1 > 3
* 1 < 2, 2 < 3 ==> 1 < 3
*
* 공통된 값은 고정으로 두고 나머지 노드 비교해야 함
* 
* i k
* k j
*
* 1 1, 1 2, 1 3, 1 4, 1 5 에서 k가 5라고 가정하면
* 5 1, 5 2, 5 3, 5 4, 5 5  위 아래 비교
*
* graph[i][k] == graph[k][j] --> i > j 
*/
class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        
        for(int[] result : results){
            int a = result[0];
            int b = result[1];
            
            graph[a][b] = 1;
            graph[b][a] = -1;
        }
        
        int answer = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(graph[i][k] == 1 && graph[i][k] == graph[k][j]){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if(graph[i][k] == -1 && graph[i][k] == graph[k][j]){
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] != 0){
                    count++;
                }
            }
            
            if(count == n - 1){
                answer++;
            }

        }
        
        return answer;
    }
}

/**
a -> b, b -> c, a -> c

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        List<List<Integer>> graph = new ArrayList<>();
        
        int[] inDegree = new int[n + 1];
        int[] count = new int[n + 1];
        boolean[][] visited = new boolean[n + 1][n + 1];
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        Arrays.fill(count, 1);
        
        for(int[] result : results){
            int a = result[0];
            int b = result[1];
            
            inDegree[b]++;
            graph.get(a).add(b);
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> complete = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 0){
                q.add(i);
                complete.add(i);
            }
        }
        
        
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            if(graph.get(curr).isEmpty()){
                for(int finish : complete){
                    if(visited[finish][curr]){
                        count[finish]++;       
                    }
                }
            }
            for(int node : graph.get(curr)){
                inDegree[node]--;
                
                if(visited[node][curr]){
                    count[curr] += 1;
                }
                
                if(!visited[curr][node]){
                    boolean compare = false;
                    
                    for(int finish : complete){
                        if(visited[finish][node]){
                            count[node] += 1;
                            compare = true;
                            break;
                        }    
                    }
                    
                    if(!compare)
                        count[node] += count[curr];
                    
                    visited[curr][node] = true;
                    visited[node][curr] = true;
                    
                    // System.out.println(node + " " + count[node]);
                }
                
                if(inDegree[node] == 0){
                    q.add(node);
                    complete.add(node);
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            if(count[i] == n){
                answer++;        
            }
            
            // System.out.println(count[i] + " ");
        }
        
        
        return answer;
    }
}
 */