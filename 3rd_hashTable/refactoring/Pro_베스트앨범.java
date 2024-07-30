package refactoring;

import java.util.*;

public class Pro_베스트앨범 {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic","test"};
        int[] plays = {2500, 600, 150, 800, 2500, 2500,300};
        Solution solution = new Solution();
        int[] result = solution.solution(genres, plays);
        System.out.println(Arrays.toString(result));

    }

    static class Solution{
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            int index = 0 ;
            // 합 , 인덱스, 2개이상인지 ?
            Map<String, Integer> sumMap = new HashMap<>();
            Map<String, Map<Integer, Integer>> map = new HashMap<>();

            for (String s : genres) {
                Map<Integer, Integer> indexMap = map.computeIfAbsent(s, k-> new HashMap<>());
                indexMap.put(index,plays[index]);
                sumMap.merge(s, plays[index], Integer::sum);
                index++;
            }

            List<String> keySet = new ArrayList(sumMap.keySet());
            // 내림차순
            Collections.sort(keySet, (s1, s2) -> sumMap.get(s2) - sumMap.get(s1) );

            List<Integer> resultList = new ArrayList<>();
            for (String s : keySet) {
                Map<Integer, Integer> keySetMap = map.get(s);
                List<Map.Entry<Integer, Integer>> list = new ArrayList(keySetMap.entrySet());
                list.sort((s1,s2) -> s2.getValue() - s1.getValue());

                resultList.add(list.get(0).getKey());
                if(list.size()>1) resultList.add(list.get(1).getKey());
            }

            return resultList.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
