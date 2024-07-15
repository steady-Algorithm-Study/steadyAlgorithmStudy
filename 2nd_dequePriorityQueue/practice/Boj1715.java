package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0 ; i< n ; i ++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(pq.size() > 1){
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            result += sum;
        }

        System.out.println(result);
    }
}

