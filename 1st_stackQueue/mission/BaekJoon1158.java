package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> qe = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n ; i ++){
            qe.offer(i);
        }
        int m = Integer.parseInt(st.nextToken());
        while(qe.size()  > 1){

            for(int i = 1; i < m; i++){
                qe.offer(qe.poll());
            }
            sb.append(qe.poll()+", ");
        }
        sb.append(qe.poll() + ">");

        System.out.println(sb);
    }
}
