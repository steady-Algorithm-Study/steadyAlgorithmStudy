package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2776 {
    static int[] su1;
    static String[] su2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0 ; k < T ; k ++){

            int N = Integer.parseInt(br.readLine());
            su1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i ++){
                su1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(su1);
            int M = Integer.parseInt(br.readLine());
            su2 = br.readLine().split(" ");
            solution();
        }
        System.out.println(sb);

    }
    static void solution(){
        for (String s : su2) {
            int num = Integer.parseInt(s);
            int start = 0;
            int end = su1.length - 1;
            boolean chk = false;

            while(start <= end){
                int half = (start + end) / 2;
                if(su1[half] == num) {
                    sb.append("1").append("\n");
                    chk = true;
                    break;
                }

                if(su1[half] > num){
                    end = half - 1;
                }else{
                    start = half + 1;
                }
            }
            if(!chk) sb.append("0").append("\n");
        }

    }
}
