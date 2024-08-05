package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1916_플로이드와샬_시간초과 {
    static int N, M;
    static int INF = Integer.MAX_VALUE / 2;
    static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        distance = new int[N+1][N+1];
        for(int i = 1; i<= N; i++){
            for(int j =1 ; j<= N; j++){
                if(i==j) continue;
                distance[i][j] = INF;
            }
        }

        for(int i = 0; i< M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = Math.min(distance[a][b],c);
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        System.out.println(distance[x][y]);

    }
}
