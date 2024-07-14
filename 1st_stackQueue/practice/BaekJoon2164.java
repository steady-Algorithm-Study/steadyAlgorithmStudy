package algorithm.changhee.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> qe = new LinkedList<>();
        for(int i = 1; i <= n ; i++){
            qe.offer(i);
        }
        while(qe.size() > 1){
            qe.poll();
            qe.offer(qe.poll());
        }
        System.out.println(qe.poll());

    }
}
