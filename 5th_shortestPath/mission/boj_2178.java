package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {

    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};  // 오른쪽, 왼쪽, 아래, 위 순서로 이동
    static int n, m;
    static int[][] graph;

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});  // 0, 0에서 시작
        graph[0][0] = 0;  // 시작 지점을 방문 처리
        int answer = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int currentX = current[0];
                int currentY = current[1];

                for (int j = 0; j < 4; j++) {
                    int x = currentX + disX[j];
                    int y = currentY + disY[j];

                    if (x == n - 1 && y == m - 1) return answer + 1;  // 목적지 도달 시
                    if (x >= 0 && x < n && y >= 0 && y < m && graph[x][y] == 1) {
                        graph[x][y] = 0;  // 방문 처리
                        q.offer(new int[]{x, y});
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];  // 0부터 시작하도록 수정

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(bfs());
    }
}
