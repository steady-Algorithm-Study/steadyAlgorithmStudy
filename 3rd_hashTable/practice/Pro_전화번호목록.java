package practice;

import java.util.*;

public class Pro_전화번호목록 {

    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123","456","789"};

        System.out.println(solution(phone_book));


    }

        public static boolean solution(String[] phone_book) {
            boolean answer = true;

            Set<String> set = new HashSet<>();
            for (String s : phone_book) {
                set.add(s);
            }

            for (String s : phone_book) {
                for(int i = 1; i < s.length() ; i++){
                    if(set.contains(s.substring(0,i))) return false;
                }
            }

            return answer;

        }




}




