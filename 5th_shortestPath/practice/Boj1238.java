package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1238 {

        static int max = Integer.MAX_VALUE / 2;
        static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        distance = new int[N+1][N+1];

        for(int i = 1; i<= N; i++){
            for(int j=1; j<= N; j++){
                if(i==j)continue;
                distance[i][j] = max;
            }
        }

        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = Math.min(distance[a][b],c);
        }

        for(int k = 1; k<= N; k++){
            for(int i = 1; i<=N; i++) {
                for (int j = 1; j <= N; j++) {
                    distance[i][j] = Math.min(distance[i][j] ,distance[i][k] + distance[k][j]);
                }
            }
        }

        int result = 0;
            for(int j= 1; j<= N; j++){
                    result = Math.max(result, distance[X][j] + distance[j][X]);
        }

        System.out.println(result);
    }
}
