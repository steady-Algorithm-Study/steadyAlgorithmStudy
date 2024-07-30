package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2023 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    static void DFS(int num, int n){
        if(n == N){
            System.out.println(num);
            return;
        }

        for(int i = 0 ; i < 10; i++){
            int next = num * 10 + i;
            if(isPrime(next)) DFS(next, n+1);
        }

    }

    static boolean isPrime(int num){
        for(int i = 2; i<= Math.sqrt(num); i ++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
