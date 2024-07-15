package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i ++){
            int m = Integer.parseInt(br.readLine());
            int result = 0;
            Deque<Integer> dq = new LinkedList<>();

            if(m == 0 ){

                if(pq.isEmpty()){
                    sb.append(result + "\n");
                }
                else{
                    if(map.get(pq.peek()) == null){
                        result = pq.poll();

                    }else {
                        if(map.get(pq.peek()).isEmpty()){
                            result = pq.poll();
                        }else{
                            int temp = map.get(pq.peek()).poll();
                            result = (pq.poll() * temp) ;
                        }
                    }
                    if( i == n-1){
                        sb.append(result);
                    }else {
                        sb.append(result + "\n");
                    }
                }

            }else if(m < 0){
                // 0보다 작을때
                if(map.get(-1 * m) == null) {
                    dq.offer(-1);
                    map.put(-1 * m,dq);
                }else{
                    Deque<Integer> deque = map.get(-1 * m);
                    deque.offer(-1);
                    map.put(-1 * m , deque);
                }
                pq.offer(-1 * m);
            }else {
                pq.offer(m);
            }
        }
        System.out.println(sb);
    }
}
