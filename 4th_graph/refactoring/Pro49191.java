import java.util.*;

class Pro49191 {
    static public int solution(int n, int[][] results) {
        int cnt = 0;

        ArrayList<Integer>[] winList = new ArrayList[n + 1];
        ArrayList<Integer>[] defeatList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            winList[i] = new ArrayList<>();
            defeatList[i] = new ArrayList<>();
        }

        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            winList[a].add(b);
            defeatList[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            int winCount = 0;
            int defeatCount = 0;

            boolean[] winVisited = new boolean[n + 1];
            boolean[] defeatVisited = new boolean[n + 1];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            winVisited[i] = true;

            while (!queue.isEmpty()) {
                int x = queue.poll();

                for (int t : winList[x]) {
                    if (!winVisited[t]) {
                        queue.add(t);
                        winVisited[t] = true;
                        winCount++;
                    }
                }
            }

            queue.add(i);
            defeatVisited[i] = true;

            while (!queue.isEmpty()) {
                int x = queue.poll();

                for (int t : defeatList[x]) {
                    if (!defeatVisited[t]) {
                        queue.add(t);
                        defeatVisited[t] = true;
                        defeatCount++;
                    }
                }
            }

            if (winCount + defeatCount == n - 1) {
                cnt++;
            }
        }

        return cnt;
    }
}