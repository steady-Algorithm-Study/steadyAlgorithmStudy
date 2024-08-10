package practice;


import com.sun.source.tree.YieldTree;

import java.util.*;

public class Pro_여행경로 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "BBB"}, {"BBB", "ICN"}, {"ICN", "AAA"}};
        String[] solution1 = solution.solution(tickets);
        for (String s : solution1) {
            System.out.println("s = " + s);
        }

    }



    static class Solution {
        static boolean[] visited;
        static String[][] ticketArr;
        static int length;
        static ArrayList<String> resultList = new ArrayList<>();

        public String[] solution(String[][] tickets) {
            ticketArr = tickets;
            length = tickets.length;
            visited = new boolean[length];

            DFS(0, "ICN", "ICN");


            Collections.sort(resultList);
            return resultList.get(0).split(",");
        }

        static void DFS(int depth, String start, String path){
            if(depth == length){
                resultList.add(path);
                return;
            } else {
                for (int i = 0; i < length; i++) {
                    if (!visited[i] && start.equals(ticketArr[i][0])) {
                        visited[i] = true;
                        DFS(depth + 1, ticketArr[i][1], path + "," + ticketArr[i][1]);
                        visited[i] = false;
                    }
                }
            }
        }
    }

}
