package mission;

import java.util.Scanner;
import java.util.Stack;

public class n1935 {
    public double solution(char[] arr, int[] temp) {
        Stack<Double> stack = new Stack<Double>();
        double lt = 0, rt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 65 && arr[i] <= 90) {
                stack.push((double)temp[arr[i]-65]);
            } else {
                rt = stack.pop();
                lt = stack.pop();

                if(arr[i]=='+') stack.push(lt + rt);
                if(arr[i]=='-') stack.push(lt - rt);
                if(arr[i]=='*') stack.push(lt * rt);
                if(arr[i]=='/') stack.push(lt / rt);

            }
        }
        return stack.pop();

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int[] temp=new int[n];
        for (int i = 0; i < n; i++) {
            temp[i]=sc.nextInt();
        }
        n1935 t = new n1935();
        System.out.printf("%.2f",t.solution(arr,temp));
    }
}
