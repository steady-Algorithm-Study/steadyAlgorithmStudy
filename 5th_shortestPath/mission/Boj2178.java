package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {

    static int[] dx = {0, 1 , 0 ,-1};
    static int[] dy = {1, 0 , -1 ,0};
    static int[][] list;
    static boolean[] visited;
    static int N, M;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[N][M];
        list = new int[N][M];
        for(int i = 0 ; i< N; i ++){
            String s = br.readLine();
            for(int j = 0; j< M; j++){
                list[i][j] = (Integer.parseInt(String.valueOf(s.charAt(j))));
            }
        }
        BFS();
        System.out.println(result[N-1][M-1] + 1);
    }
    static void BFS(){
        Queue<int[]> qe = new LinkedList<>();
        qe.offer(new int[]{0,0});

        while(!qe.isEmpty()){
            int[] poll = qe.poll();
            int xx = poll[0];
            int yy = poll[1];

            for(int i = 0; i< 4; i ++){
                int x = xx + dx[i];
                int y = yy + dy[i];

                if(x >= 0 && y >= 0 && x < N && y < M && list[x][y] == 1){
                    list[x][y] = 0;
                    result[x][y] = result[xx][yy]+1;
                    qe.add(new int[]{x,y});
                }
            }
        }
    }
}
