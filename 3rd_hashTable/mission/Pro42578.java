import java.util.HashMap;

public class Pro42578 {
    public int solution(String[][] clothes) {
        int ans = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (!map.keySet().contains(clothes[i][1])) {
                map.put(clothes[i][1], 1);
            } else {
                int tmp = map.get(clothes[i][1]);
                map.put(clothes[i][1], tmp + 1);
            }
        }

        for (String str : map.keySet()) {
            ans *= map.get(str) + 1;
        }

        return ans - 1;
    }
}