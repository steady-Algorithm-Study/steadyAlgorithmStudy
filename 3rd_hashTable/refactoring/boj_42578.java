package refactoring;

import java.util.HashMap;
import java.util.Iterator;


public class boj_42578 {

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            hm.put(type, hm.getOrDefault(type, 0) + 1);
        }

        Iterator<Integer> iter = hm.values().iterator();

        while (iter.hasNext()) {
            answer *= iter.next().intValue() + 1;
        }

        return answer - 1;
    }
}