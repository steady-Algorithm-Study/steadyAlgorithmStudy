package refactoring;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Boj13904  {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Function<String,Integer> fn = Integer::parseInt;
    int n = fn.apply(br.readLine());
    PriorityQueue<Score>[] priorityQueue = new PriorityQueue[n+1];
    PriorityQueue<Score> pq = new PriorityQueue<>();
    int result = 0;
    int index = 0;
    for(int i = 0 ; i<= n; i ++) {
        priorityQueue[i] = new PriorityQueue<>();
    }
    for(int i = 1 ; i<= n; i ++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = fn.apply(st.nextToken());
        int b = fn.apply(st.nextToken());
        pq.offer(new Score(a, b));
        }

    for(int i = 1 ; i <= n; i ++){
        priorityQueue[i].offer(pq.poll());
    }

    PriorityQueue<Integer> resultpq = new PriorityQueue<>();
    index = 1;
    for(int i = 1; i < priorityQueue.length; i ++){
        if(i == priorityQueue.length-1) {
            index = priorityQueue[i].peek().end ;
            resultpq.offer(priorityQueue[i].poll().score);


        }else if(!priorityQueue[i].isEmpty() ) {
             Score poll = priorityQueue[i].poll();
             resultpq.offer(poll.score);
             index = poll.end;
                while (poll.end == priorityQueue[i+1].peek().end) {
                    i++;
                    if(i == priorityQueue.length-1) {
                        index = priorityQueue[i].peek().end ;
                        resultpq.offer(priorityQueue[i].poll().score);

                        break;
                    }
                    resultpq.offer(poll.score);
                    poll = priorityQueue[i].poll();
                    index = poll.end;
                    if(poll.end != priorityQueue[i+1].peek().end){
                        resultpq.offer(poll.score);
                        index = poll.end;
                    }
                }


        }
        while(index < resultpq.size()){
            resultpq.poll();
        }
    }
    for (Integer i : resultpq) {
        result += i;
    }
    System.out.println(result);
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
                return Integer.compare(this.end, s.end);
            }
            return Integer.compare(this.score, s.score);
        }

    }


}