package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {

    static int[] dx = { 0 , 1, 0 ,-1};
    static int[] dy = {1, 0 , -1 , 0};
    static boolean[][] visited;
    static int[][] node;
    static int N;
    static int M;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        node = new int[N][M];
        for(int i = 0; i<N; i ++){
            String s = br.readLine();
            for(int j = 0; j < M; j ++){
                node[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }
            BFS(0,0);
        System.out.println(node[N-1][M-1]);


    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                int k = now[0] + dx[i];
                int p = now[1] + dy[i];
                if(k>= 0 && p>=0 && k<N && p < M){
                    if(node[k][p] != 0 && !visited[k][p]){
                        visited[k][p] = true;
                        node[k][p] = node[now[0]][now[1]] + 1;
                        queue.add(new int[]{k, p});
                    }
                }
            }
        }

    }

}
