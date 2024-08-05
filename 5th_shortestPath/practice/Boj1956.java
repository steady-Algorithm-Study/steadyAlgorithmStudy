package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1956 {

    static int[][] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        distance = new int[V+1][V+1];
        visited = new boolean[V+1];
        for(int i = 1; i<= V; i++){
            for(int j = 1; j<=V; j++){
               distance[i][j] = Integer.MAX_VALUE/2;
            }
        }

        for(int i = 0; i< E; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(distance[a][b] > c) distance[a][b] = c;
        }

        for(int k = 1; k<= V; k++){
            for(int i = 1; i<=V; i++){
                for(int j= 1; j<= V; j++){
                    if(i==j) continue;
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int max = Integer.MAX_VALUE / 2;
        int ans = max;
        for(int i = 1; i<= V; i++){
            for(int j = 1; j<= V; j++){
                if(distance[i][j] != max && distance[j][i] != max){
                    ans = Math.min(ans , distance[i][j] + distance[j][i]);
                }
            }
        }
        if(ans == Integer.MAX_VALUE/2) ans = -1;
        System.out.println(ans);

    }
}
