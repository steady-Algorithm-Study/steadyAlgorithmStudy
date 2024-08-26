import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj12891 {
    public static void main(String[] args) throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        for (int i = 0; i < P; i++) {
            switch (arr[i]) {
                case 'A':
                    map.put('A', map.get('A') + 1);
                    break;
                case 'C':
                    map.put('C', map.get('C') + 1);
                    break;
                case 'G':
                    map.put('G', map.get('G') + 1);
                    break;
                case 'T':
                    map.put('T', map.get('T') + 1);
                    break;
            }
        }

        int reqA = Integer.parseInt(st.nextToken());
        int reqC = Integer.parseInt(st.nextToken());
        int reqG = Integer.parseInt(st.nextToken());
        int reqT = Integer.parseInt(st.nextToken());

        if (map.get('A') >= reqA && map.get('C') >= reqC && map.get('G') >= reqG && map.get('T') >= reqT) {
            ans++;
        }

        for (int i = 0; i < S - P; i++) {
            map.put(arr[i], map.get(arr[i]) - 1);
            map.put(arr[i + P], map.get(arr[i + P]) + 1);
            if (map.get('A') >= reqA && map.get('C') >= reqC && map.get('G') >= reqG && map.get('T') >= reqT) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}