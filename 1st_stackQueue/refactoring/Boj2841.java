package refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Deque[] dq = new Deque[7];
        for(int i = 1 ; i <= 6 ; i ++){
            dq[i] = new LinkedList<>() ;
        }
        for(int i = 0; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());
            Deque<Integer> deque = dq[row];
            if(deque.isEmpty()){
                result++;
                deque.addLast(flat);
            }
            while(!deque.isEmpty() && deque.peekLast() > flat){
                result ++;
                deque.pollLast();
            }
            if(deque.isEmpty() || deque.peekLast() != flat){
                deque.addLast(flat);
                result++;
            }
            dq[row] = deque;
        }
        System.out.println(result);

    }
}

