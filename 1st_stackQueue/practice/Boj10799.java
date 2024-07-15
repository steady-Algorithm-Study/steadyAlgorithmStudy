import java.util.Scanner;
import java.util.Stack;

public class Boj10799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        int n = 0;
        int ans = 0;

        for (char c : arr) {
            if (c == '(') {
                stack.push(c);
                n++;
            } else {
                char tmp = stack.pop();
                n--;
                ans += tmp == '(' ? n : 1;
                stack.push(')');
            }
        }

        System.out.println(ans);
    }
}