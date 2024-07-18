package mission;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class n29160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>(11);

        for(int i = 1; i <= n; i++){
            //최대힙으로
            map.put(i, new PriorityQueue<Integer>(Collections.reverseOrder()));
        }
        //선수를 포지션에 맞는 위치로 할당
        for (int i = 1; i <= n; i++) {
            int p=sc.nextInt();
            int w =sc.nextInt();
            map.get(p).add(w);
        }


        //k년
        for(int j = 1; j <= k; j++) {
            //선발 선수 선택 후 -1
            for (int i = 1; i <= n; i++) {
                if (!map.get(i).isEmpty()) {
                    PriorityQueue<Integer> pq = map.get(i);
                   //선수의 점수가 0보다 큼
                    if (pq.poll() - 1 < 0) {
                        pq.offer(0);
                    }else pq.offer(pq.poll() - 1);
                }
            }
        }
        int sum = 0;

        for(int i = 1; i <= n; i++){
            sum += map.get(i).poll();
        }
        System.out.println(sum);


    }
}
