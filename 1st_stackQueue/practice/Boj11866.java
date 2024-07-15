package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        br.close();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int n = Integer.parseInt(s[1]);
        int temp = 0;
        Queue<Integer> qe = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        for(int i = 1; i <= Integer.parseInt(s[0]); i++) {
            qe.add(i);
        }
        while(qe.size() > 1){
            for(int i = 0; i < n-1 ; i++){
                qe.offer(qe.poll());
            }
            sb.append(qe.poll() + ", ");
        }

        sb.append(qe.poll() + ">");
        System.out.println(sb);


    }
}
