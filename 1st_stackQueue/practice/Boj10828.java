import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String t = st.nextToken();

            if (t.equals("push")) {
                stack.push(st.nextToken());
            } else if (t.equals("top")) {
                if (!stack.empty()) {
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (t.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (t.equals("empty")) {
                if (stack.empty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (t.equals("pop")) {
                if (!stack.empty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            }
            N--;
        }

        System.out.println(sb.toString());

    }
}