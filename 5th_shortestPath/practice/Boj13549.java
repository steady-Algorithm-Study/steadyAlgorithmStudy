package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = Integer.MAX_VALUE;

        Queue<Point> qe = new LinkedList<>();
        int[] visited = new int[100001];
        qe.offer(new Point(N, 1));

        while(!qe.isEmpty()){
                Point poll = qe.poll();

                if(poll.now == K) result = Math.min(result, poll.time);

            // 앞으로 1칸
                if(poll.now + 1 >= 0 && poll.now+1 <= 100000){
                    if(visited[poll.now + 1] == 0 || visited[poll.now + 1] > poll.time + 1){
                        visited[poll.now + 1] = poll.time + 1;
                        qe.add(new Point(poll.now +1, poll.time + 1));
                    }
                }

            // 뒤로 1칸
                if(poll.now - 1 >= 0 && poll.now -1 <= 100000){
                    if(visited[poll.now - 1] == 0 || visited[poll.now - 1] > poll.time +1){
                        visited[poll.now - 1] = poll.time + 1;
                        qe.add(new Point(poll.now -1 , poll.time + 1 ));
                    }
                }

            // 2배
                if(poll.now * 2 >= 0 && poll.now * 2 <= 100000){
                    if(visited[poll.now * 2] == 0 || visited[poll.now * 2] > poll.time){
                        visited[poll.now * 2] = poll.time;
                        qe.add(new Point(poll.now * 2, poll.time));
                    }
                }
        }

        System.out.println(result - 1);

    }

    static class Point{
        int now;
        int time;

        public Point(int now, int time) {
            this.now = now;
            this.time = time;
        }
    }
}
