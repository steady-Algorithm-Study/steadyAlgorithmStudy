package algorithm.changhee.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon28278 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        for(int i=0; i < n ; i++){
            String[] s = br.readLine().split(" ");
            commandStack(stack, s);
        }


    }


    public static void  commandStack(Stack st, String[] str){

        int result = -1;
        switch(Integer.parseInt(str[0])){
            case 1: stack.push(Integer.parseInt(str[1]));
                return;
            case 2: if(!st.empty()){
                result = (int) st.pop();
            }
                break;
            case 3:
                result = st.size();
                break;
            case 4:
                result = st.isEmpty() ? 1 : 0;
                break;
            case 5:
                result = st.isEmpty() ? -1 : (int) st.peek();
                break;
        }
        System.out.println(result);

    }
}
