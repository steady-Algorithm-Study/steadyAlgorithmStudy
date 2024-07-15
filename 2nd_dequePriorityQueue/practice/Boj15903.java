package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Long result = 0L;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            Long num = Long.parseLong(st.nextToken());
            pq.add(num);
        }

        for(int i = 0; i < m; i ++){
            Long sum = (pq.poll() + pq.poll());
            pq.add(sum);
            pq.add(sum);
        }

        for (Long i : pq) {
            result += i;
        }
        System.out.println(result);
    }
}