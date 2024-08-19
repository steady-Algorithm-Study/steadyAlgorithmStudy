package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1654 {
    static int[] lan;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
         K = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
        lan = new int[K];
        long start = 1;
        long end  = 0;
        for(int i = 0; i < K ; i ++){
            lan[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, lan[i]);
        }

        long half = (start + end ) /2;
        long result = chop(half);
        while(start <= end){

            if( result < N){
                end = half -1;
            }else{
                start = half + 1;
            }

            half = (start + end ) / 2;
            result = chop(half);
        }

        System.out.println(half);

    }

    static long chop(long num){
        long sum = 0;
        for (int i : lan) {
            if ( i > 0 && num > 0) sum += i / num;
        }

        return sum;
    }
}
