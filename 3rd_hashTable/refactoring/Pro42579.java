import java.util.*;

public class Pro42579 {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            // 두 가지 HashMap 준비
            // 1. 각 장르별로 재생된 수의 합을 저장하는 HashMap
            // 2. 각 장르 내의 Music 정보를 저장하는 HashMap (고유번호 값과 재생 수를 저장)
            HashMap<String, Integer> totalPlayCntMap = new HashMap<>();
            HashMap<String, PriorityQueue<Music>> prioQueueMap = new HashMap<>();

            ArrayList<Integer> arr = new ArrayList<>();

            // 저장
            for (int i = 0; i < genres.length; i++) {
                String g = genres[i];
                if (!totalPlayCntMap.containsKey(g)) {
                    totalPlayCntMap.put(g, plays[i]);
                } else {
                    int tmp = totalPlayCntMap.get(g);
                    totalPlayCntMap.put(g, tmp + plays[i]);
                }

                if (!prioQueueMap.containsKey(g)) {
                    prioQueueMap.put(g, new PriorityQueue<Music>());
                }

                prioQueueMap.get(g).offer(new Music(i, plays[i]));
            }

            // 1번 HashMap을 value 내림차순으로 정렬
            List<String> li = new ArrayList<>(totalPlayCntMap.keySet());
            Collections.sort(li, (o1, o2) -> totalPlayCntMap.get(o2) -  totalPlayCntMap.get(o1));

            // 1번 HashMap 순서대로 2번 HashMap에서 최대 2개까지 선택
            // 이때, PriorityQueue가 cnt가 가장 크며, 같을 경우 고유번호가 더 작은 것을 골라 줌
            for (String s : li) {
                for (int i = 0; i < 2; i++) {
                    if (prioQueueMap.get(s).isEmpty()) continue;
                    arr.add(prioQueueMap.get(s).poll().num);
                }
            }

            int[] ansArr = arr.stream().mapToInt(Integer::intValue).toArray();

            return ansArr;
        }

        static class Music implements Comparable<Music> {
            int num;
            int cnt;

            Music (int num, int cnt) {
                this.num = num;
                this.cnt = cnt;
            }

            // 우선순위 큐 사용을 위한 우선순위 부여를 위해 Override
            @Override
            public int compareTo(Music o) {
                if (this.cnt == o.cnt) return this.num - o.num;
                else return o.cnt - this.cnt;
            }
        }
    }
}
