package mission;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1325 {
    static int n;
    static ArrayList<ArrayList<Integer>> list;
    static int[] count;
    static int max = 0;

    public static int bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int L = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            L++;
            for (int num : list.get(x)) {
                if (!visited[num]) {
                    visited[num] = true;
                    q.add(num);
                }
            }
        }
        return L;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.get(y).add(x);
        }

        count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            count[i] = bfs(i);
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}
