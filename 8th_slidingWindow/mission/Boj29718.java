import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj29718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] clapArr = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                clapArr[j] += Integer.parseInt(st.nextToken());
            }
        }

        int A = Integer.parseInt(br.readLine());
        int clapSum = 0;

        for (int i = 0; i < A; i++) {
            clapSum += clapArr[i];
        }

        int ans = clapSum;

        for (int i = 0; i < M - A; i++) {
            clapSum -= clapArr[i];
            clapSum += clapArr[i + A];
            ans = Math.max(clapSum, ans);
        }

        System.out.println(ans);
    }
}