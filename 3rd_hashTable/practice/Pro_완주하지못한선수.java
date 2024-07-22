package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Pro_완주하지못한선수 {
    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant,completion));
    }


        public static String solution(String[] participant, String[] completion) {
            String answer = "";
            int index = 0;

            Arrays.sort(participant);
            Arrays.sort(completion);

            while (true) {
                if (index == participant.length - 1) {
                    answer = participant[index];
                    break;
                } else if (participant[index].equals(completion[index])) {
                    index++;
                } else {
                    answer = participant[index];
                    break;
                }
            }
            return answer;
        }




}







