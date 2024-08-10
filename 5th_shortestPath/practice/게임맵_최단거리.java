package practice;

import java.util.*;
class Solution {
    static int[] disX={1,-1,0,0};
    static int[] disY={0,0,-1,1};


    public static int dfs(int[][] maps){
        Queue<Integer[]> q=new LinkedList<>();
        q.offer(new Integer[]{0,0});

        int answer=1;
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                Integer[] dis=q.poll();

                for(int j=0;j<4;j++){
                    int x=dis[0]+disX[j];
                    int y=dis[1]+disY[j];
                    if(x==maps.length-1&&y==maps[0].length-1) return answer+1;
                    if(x>=0&&x<maps.length&&y>=0&&y<maps[0].length&&maps[x][y]==1){
                        maps[x][y]=0;
                        q.offer(new Integer[]{x,y});
                    }
                }
            }answer++;
        }return answer=-1;
    }
    public int solution(int[][] maps) {
        return dfs(maps);
    }
}