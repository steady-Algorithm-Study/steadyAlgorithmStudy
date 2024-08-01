package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_네트워크 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(3, new int[][] {{1,1,0}, {1,1,0},{0,0,1}}));
    }

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count;
    static class Solution{
        public int solution(int n, int[][] computers){
            int answer = 0;
            visited = new boolean[n];
            list = new ArrayList[n];
            for(int i = 0; i < n; i ++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i< n; i++) {
                for (int j = 0; j < n; j++) {
                    if(computers[i][j] == 1 && i != j)
                        list[i].add(j);
                }
            }

            for(int i = 0; i < n; i ++) {
                   BFS(i);
            }

            return count;
        }


        static void BFS(int a){
            if(visited[a]) return;
            Queue<Integer> qe = new LinkedList<>();
            count++;
            qe.offer(a);
            visited[a] = true;
            while(!qe.isEmpty()){
                Integer poll = qe.poll();
                for (Integer i : list[poll]) {
                    if(!visited[i]){
                        visited[i] = true;
                        qe.offer(i);
                    }
                }
            }

        }



        }
    }

