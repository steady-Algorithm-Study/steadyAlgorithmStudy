import java.util.*;

public class Pro42579 {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            HashMap<String, Integer> totalPlayCntMap = new HashMap<>();
            HashMap<String, PriorityQueue<Music>> prioQueueMap = new HashMap<>();
            ArrayList<Integer> arr = new ArrayList<>();

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



            List<String> li = new ArrayList<>(totalPlayCntMap.keySet());

            Collections.sort(li, (o1, o2) -> totalPlayCntMap.get(o2) -  totalPlayCntMap.get(o1));

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

            @Override
            public int compareTo(Music o) {
                if (this.cnt == o.cnt) return this.num - o.num;
                else return o.cnt - this.cnt;
            }
        }
    }
}
