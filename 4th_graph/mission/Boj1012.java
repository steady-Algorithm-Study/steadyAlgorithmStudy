package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012 {
    static int[][] node ;
    static int[] xArr = {0, 1, 0 , -1};
    static int[] yArr = {1,0,-1,0};
    static int N,K, M;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i ++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            node = new int[M+1][N+1];
            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                node[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for(int j = 0; j < M; j ++){
                for(int k = 0; k < N; k++){
                    if(node[j][k] == 1 ) {

                        BFS(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void BFS(int x, int y){
        Queue<int[]> qe = new LinkedList<>();
        qe.offer(new int[]{x,y});

        node[x][y] = 0;
        while(!qe.isEmpty()){
            int[] now = qe.poll();

            for(int i =0; i< 4; i ++){
              int  k = now[0] + xArr[i];
              int p = now[1] + yArr[i];
                if(k >= 0 && p >= 0 && k < M && p < N){
                    if(node[k][p] != 0 ) {
                        node[k][p] = 0;
                        qe.offer(new int[]{k, p});
                    }
                }
            }
        }

    }
}
