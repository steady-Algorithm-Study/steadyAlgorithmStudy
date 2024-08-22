package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13702 {
    static int[] drink;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long max = 0;
        drink = new int[N];
        long start = 1;
        long end = 0;
        for(int i = 0; i < N; i++){
            drink[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, drink[i]);
        }

        long mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            long cnt = 0;
            for(int i = 0; i < N; i++){

                cnt += (drink[i]/mid);
            }

                if (cnt < K) {
                    end = mid - 1;
                } else {
                    start = mid + 1;

                }

        }

        System.out.println(start - 1);



    }
}
