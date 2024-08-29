import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int a = 0;
            int b = 0;

            for (int i = 0; i < W.length(); i++) {
                char tmp = W.charAt(i);
                if (!map.keySet().contains(tmp)) {
                    map.put(tmp, 0);
                }
            }

            for (int i = K; i <= W.length(); i++) {
                for (int j = 0; j < K; j++) {
                    map.put(W.charAt(j), map.get(W.charAt(j)) + 1);
                }


            }
        }
    }
}
