package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/196 페이지 참조
public class Boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        int[] result = new int[n];
        for(int i= 0; i< n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = -1;
        }
        br.close();
        for(int i = 0 ; i < n; i ++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        for (int i : result) {
            sb.append(i + " ");
        }

        System.out.println(sb);

    }

}

