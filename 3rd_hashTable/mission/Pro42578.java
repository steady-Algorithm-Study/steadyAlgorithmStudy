import java.util.*;

/**
    의상
    시간복잡도: O(N)
 */
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        for(String kind : map.keySet()){
            answer *= map.get(kind) + 1;
        }
        
        return answer - 1;
        
    }
}