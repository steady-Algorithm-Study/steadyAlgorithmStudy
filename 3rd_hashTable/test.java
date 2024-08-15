import java.util.*;

import static java.util.stream.Collectors.*;

public class test {
    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] playes = new int[]{500, 600, 150, 800, 2500};


        Map<String, List<Integer>> map = new HashMap<>();


        for(int i=0;i<genres.length;i++){
            List<Integer> list=map.getOrDefault(genres[i], new ArrayList<>());
            list.add(playes[i]);
        }
        //key별로 가장 큰 점수를 가진 genres추출
        String maxGenres = map.entrySet().stream()
                .collect(maxBy(Comparator.
                        comparingInt(x -> x.getValue().stream()
                                .mapToInt(Integer::intValue).sum()))).get().getKey();

        System.out.println(maxGenres);
    }
}
