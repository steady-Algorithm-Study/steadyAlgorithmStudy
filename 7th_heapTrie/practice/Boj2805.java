package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2805 {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tree = new int[N];
        int start = 0;
        int end = 0;
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
        }
        int half = (start+end) / 2 ;
        long sum = sum(half);
        while(start <= end){
           if(sum < M){
               end = half -1;
           }else{
               start = half + 1;
           }

           half = (start + end) / 2;
           sum = sum(half);
        }
        System.out.println(half);
    }

    private static long sum(int half) {
        long sum = 0;
        for (int i : tree) {
            if( i > half) sum += i - half;
        }
        return sum;
    }
}
