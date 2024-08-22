package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1253 {
    static int[] arr;
    static int count;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

            Arrays.sort(arr);
            for(int i = 0; i < N; i ++) {
                solution(i);
            }

        System.out.println(count);

    }
    static void solution(int num){
        int start = 0;
        int end = N - 1 ;
        int n = arr[num];
            while (start < end) {

               int sum = arr[start] + arr[end];

               if(sum == n){
                   if(start != num && end != num){
                       count++;
                       return;
                   }else if(start == num){
                       start++;
                   }else{
                       end--;
                   }

               }else if( sum < n){
                   start++;
               }else{
                   end --;
               }
            }
    }
}
