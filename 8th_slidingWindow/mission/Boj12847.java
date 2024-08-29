import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());

        int[] pay = new int[n + 1];
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
        }

        long s = 0;

        for (int i = 1; i <= m; i++) {
            s += pay[i];
        }

        ans = s;

        for (int i = 1; i <= n - m; i++) {
            s -= pay[i];
            s += pay[i + m];
            ans = Math.max(ans, s);
        }

        System.out.println(ans);
    }
}
