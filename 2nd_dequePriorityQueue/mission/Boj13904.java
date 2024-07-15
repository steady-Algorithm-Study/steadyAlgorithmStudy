package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13904 {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Score>[] pq = new PriorityQueue[n];
    for(int i = 0 ; i< n; i ++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        pq[a].offer(new Score(a, b));
    }

    // 남은 일수와 점수를 같이 생각하면서 하는법 ?

}

static class Score {
    int end;
    int score;

    public Score(int end, int score) {
        this.end = end;
        this.score = score;
    }

    public int getEnd() {
        return end;
    }

    public int getScore() {
        return score;
    }
}
}