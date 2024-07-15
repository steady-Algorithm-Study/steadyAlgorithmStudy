package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj29160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] pq = new PriorityQueue[n];
        // n 이 0일때
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> val = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> val2 = new PriorityQueue<>(Comparator.reverseOrder());
            while (st.hasMoreTokens()){
                int value = Integer.parseInt(st.nextToken());
                val.offer(value);
            }
            val2.offer(val.peek());
            pq[index-1] = val;
        }


        for(int i = 0; i < n; i ++){
            for(int j = 0; j < k; j++){
                if(!pq[i].isEmpty() && pq[i].peek() == 0){
                    continue;
                }else{
                    pq[i].offer(pq[i].poll() - 1);
                }
            }
        }


        int result = 0;
        for(int i = 0; i < n; i ++){
            result += pq[i].poll();
        }
        System.out.println(result);
    }
}


