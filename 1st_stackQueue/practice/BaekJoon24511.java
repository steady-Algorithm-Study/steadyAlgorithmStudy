package algorithm.changhee.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BaekJoon24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> qe = new LinkedList<>();
        String[] questack = br.readLine().split(" ");
        String[] arr = br.readLine().split(" ");
        for(int i = 0; i < n ; i++){
            if(questack[i].equals("0")){
                qe.offer(Integer.parseInt(arr[i]));
            }
        }
        int m = Integer.parseInt(br.readLine());
        if(qe.isEmpty()){
            System.out.println(br.readLine());
        }else {
            String[] numArr = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                qe.addFirst(Integer.parseInt(numArr[i]));
                sb.append(qe.pollLast() + " ");
            }
            System.out.println(sb);
        }

    }
}

