package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_게임_맵_최단거리 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution.solution(arr));
    }

    static class Solution{
        static int[][] result;
        static int[] dx = {0, 1 , 0 , -1};
        static int[] dy = {1,0,-1,0};
        static int N,M;
        static boolean[][] visited;
        public int solution(int[][] maps){
            int answer = 0;
            N = maps.length;
            M = maps[0].length;
            visited = new boolean[N][M];
            result = new int[N][M];

            result[0][0] = 1;
            Queue<int[]> qe = new LinkedList<>();
            qe.add(new int[]{0,0});

            while(!qe.isEmpty()){
                int[] poll = qe.poll();
                int xVertex = poll[0];
                int yVertex = poll[1];

                visited[xVertex][yVertex] = true;
                for(int i = 0; i< 4; i++){
                    int x = xVertex + dx[i];
                    int y = yVertex + dy[i];
                    if( x >= 0 && y >= 0 && x < N && y < M && maps[x][y] == 1){
                        if(!visited[x][y]) {
                            result[x][y] = result[xVertex][yVertex] + 1;
                            visited[x][y] = true;
                            qe.add(new int[]{x, y});
                        }

                    }
                }
            }
            if(result[N-1][M-1] == 0) return -1;

            return result[N-1][M-1];
        }
    }
}
