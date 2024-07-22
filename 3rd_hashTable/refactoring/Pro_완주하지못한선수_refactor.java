package refactoring;
import java.util.HashMap;
import java.util.Map;

public class Pro_완주하지못한선수_refactor {
        public static void main(String[] args) {
            String[] participant = {"leo", "kiki", "eden"};
            String[] completion = {"eden", "kiki"};
            System.out.println(solution(participant,completion));
        }

        public static String solution(String[] participant, String[] completion) {
            String answer = "";
            Map<String, Integer> map = new HashMap<>();
            for (String s : completion) {
                int num = 1;
                if (map.get(s) == null) num = 1;
                else num = map.get(s) + 1;
                map.put(s, num);
            }

            for (String s : participant) {
                if (map.get(s) != null) {
                    int i = map.get(s) - 1;
                    if (i == -1) {
                        return s;
                    }
                    map.put(s, i);
                } else {
                    return s;
                }
            }
            return "false";
        }
    }










