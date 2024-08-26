import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj29700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] m = new int[N][M];

        if (M < K) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            m[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < K; j++) {
                if (m[i][j] == 0) cnt++;
            }

            if (cnt >= K) ans++;

            int lt = 0;

            for (int l = K; l < M; l++) {
                if (m[i][l] == 0) cnt++;
                if (m[i][lt] == 0) cnt--;
                if (cnt >= K) ans++;
                lt++;
            }
        }

        System.out.println(ans);

    }
}
