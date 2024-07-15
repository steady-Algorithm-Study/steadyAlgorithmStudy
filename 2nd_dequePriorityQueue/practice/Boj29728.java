package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Boj29728 {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> dq = new LinkedList<>();
        boolean chk = true;
        int N = Integer.parseInt(br.readLine());
        int amountB = 0;
        int amountS = 0;
        if(N > 1) {
            make_prime(N);

            extracted(chk, dq, amountB, amountS);
        }else{
            System.out.println("1 0");
        }


    }

    private static void extracted(boolean chk, Deque<String> dq, int amountB, int amountS) {
        for (int i = 1; i < prime.length; i++) {
            if (prime[i] == false) {    // 소수(false)일 경우 출력
                if (chk) {
                    if (dq.peekLast().equals("B")) {
                        dq.pollLast();
                        dq.offer("S");
                        dq.offer("S");
                    } else {
                        dq.offer("S");
                        chk = !chk;
                    }
                } else {
                    if (dq.peekFirst().equals("B")) {
                        dq.pollFirst();
                        dq.offerFirst("S");
                        dq.offerFirst("S");
                    } else {
                        dq.offerFirst("S");
                        chk = !chk;
                    }

                }
            }else{
                if(chk){
                    dq.offer("B");
                }else{
                    dq.offerFirst("B");
                }
            }

        }
        for (String s : dq) {
            if (s.equals("B")){
                amountB++;
            }else{
                amountS++;
            }
        }
        System.out.println(amountB + " " + amountS);
    }


    // N 이하 소수 생성 메소드
    public static void make_prime(int N) {

        prime = new boolean[N + 1];
        if(N < 2) {
            return;
        }
        prime[0] = prime[1] = true;


        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(N); i++) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if(prime[i] == true) {
                continue;
            }

            // i 의 배수들을 걸러주기 위한 반복문
            for(int j = i * i; j < prime.length; j = j+i) {
                prime[j] = true;
            }
        }

    }

}

