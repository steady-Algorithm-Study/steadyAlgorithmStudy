package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj12789 {
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        String[] s = br.readLine().split(" ");
        for(int i = 0; i< n ; i ++){
            int temp = Integer.parseInt(s[i]);



            if(temp == result){
                result++;
                result = solution(st,result);
            }
            else {
                result = solution(st, result);
                st.push(temp);
            }



        }
        for(int i =0 ; i < st.size(); i++){
            int pop = st.pop();
            if(result == pop){
                result++;
            }
        }
        if(result >= n){
            System.out.println("Nice");
        }else{
            System.out.println("Sad");
        }


    }

    private static int solution(Stack<Integer> st, int count) {
        while(!st.isEmpty() && st.peek() == count) {
            st.pop();
            count++;
        }
        return count;
    }
}
