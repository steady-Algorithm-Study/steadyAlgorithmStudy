package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940 {
    static int[] dx = {0, 1, 0 , -1};
    static int[] dy = {1,0,-1,0};
    static int N,M;
    static int[] start = new int[2];
    static boolean[][] visited;
    static int[][] list;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];
        for (int[] res : result) {
            Arrays.fill(res,-1);
        }
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< M ; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 2) {
                    start[0] = i;
                    start[1] = j;
                } else if(a == 0){
                    result[i][j] = 0;
                }
                list[i][j] = a;
            }
        }

        Queue<int[]> qe = new LinkedList<>();
        qe.add(new int[]{start[0],start[1]});
        result[start[0]][start[1]] = 0;
        while(!qe.isEmpty()){
            int[] poll = qe.poll();
            int x = poll[0];
            int y = poll[1];

            for(int i = 0; i< 4; i ++){
                int a = x + dx[i];
                int b = y + dy[i];
                if(a >= 0 && b >= 0 && a < N && b < M && list[a][b] == 1){
                    list[a][b] = 0;
                    qe.offer(new int[]{a, b});
                    result[a][b] = result[x][y] + 1;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< N; i++){
            for(int j = 0 ; j< M ; j++){
                sb.append(result[i][j] + " ");

            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
