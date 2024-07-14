package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int stature = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int result = 0;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < n; i ++){
            int add = Integer.parseInt(br.readLine());
            pq.offer(add);
        }
        if(pq.peek() < stature){
            sb.append("YES\n" + 0);
        }else {

            while (true) {
                if (pq.peek() == 1) {
                    System.out.println("NO\n" + 1);
                    break;
                }
                if (limit == 0) {
                    if (pq.peek() < stature) {
                        sb.append("YES\n" + result);
                    } else {
                        sb.append("NO\n" + pq.peek());
                    }
                    break;
                } else {
                    if (stature <= pq.peek()) {
                        pq.offer((int) Math.floor(pq.poll() / 2));
                        limit--;
                        result++;
                    } else {
                        sb.append("YES\n" + result);
                        break;
                    }
                }
            }
        }

        System.out.println(sb);

    }

}

