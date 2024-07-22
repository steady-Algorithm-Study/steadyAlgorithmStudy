package refactoring;


import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Boj13904_Refactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> fn = Integer::parseInt;
        int n = fn.apply(br.readLine());
        PriorityQueue<Integer>[] priorityQueue = new PriorityQueue[1001];
        PriorityQueue<Score> pq = new PriorityQueue<>();
        int result = 0;
        int index = 0;
        for(int i = 0 ; i < 1001; i ++) {
            priorityQueue[i] = new PriorityQueue<>();
        }
        for(int i = 1 ; i<= n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = fn.apply(st.nextToken());
            int b = fn.apply(st.nextToken());
            priorityQueue[a].offer(b);
            pq.offer(new Score(a, b));
        }

        PriorityQueue<Integer> resultQe = new PriorityQueue<>();
        while(!pq.isEmpty()){
            Score sc = pq.poll();
            while(!priorityQueue[sc.end].isEmpty()){
                resultQe.offer(priorityQueue[sc.end].poll());
            }
            while(sc.end < resultQe.size()){
                resultQe.poll();
            }
        }
        for (Integer i : resultQe) {
            result += i;
        }
        System.out.println(result);
        br.close();

    }
        static class Score implements Comparable<Score> {
            int end;
            int score;

            public Score(int end, int score) {
                this.end = end;
                this.score = score;
            }

            @Override
            public int compareTo(Score s) {
                if(this.end != s.end){
                    return Integer.compare(this.end,s.end);
                }
                return Integer.compare(this.score,s.score);
            }

        }
}
