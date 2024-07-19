package mission;

import java.util.Scanner;
import java.util.Stack;

public class n2841 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int answer = 0;
        //기타의 6개의 줄을 stack으로 선언
        Stack<Integer>[] stack = new Stack[n];
        for (int i = 0; i < n; i++) {
            stack[i] = new Stack<>();
        }

        for (int i = 0; i < n; i++) {
            //줄
            int x = sc.nextInt();
            //프렛
            int y = sc.nextInt();
            if (stack[x].isEmpty()) {
                stack[x].add(y);
                answer++;
            }
            // 작은 음일 경우
            else if (stack[x].peek() > y) {
                //y가 보다 큰음을 누른 손을 뗄때까지
                while (stack[x].peek() > y) {
                    answer++;
                    stack[x].pop();
                }
            }
            // 크거나 스택이 빈경우
            else {
                stack[x].add(y);
                answer++;
            }
        }
        System.out.println(answer);

    }
}
