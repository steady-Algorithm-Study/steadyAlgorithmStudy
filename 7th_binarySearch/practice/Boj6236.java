package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6236 {
    static int count, start, N, M , end = 1000000000;
    static int[] money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        for(int i = 0; i < N; i++){
            money[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, money[i]);
        }

        solution();

    }
    static void solution(){
        while(start <= end){
            count=1;
            int mid = (start + end) / 2;
            int temp = mid;
            for(int i = 0; i < N; i ++){
                if(temp - money[i] < 0){
                    temp = mid;
                    count++;
                }
                temp -= money[i];
            }

            if(count > M){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        System.out.println(start);
    }
}
