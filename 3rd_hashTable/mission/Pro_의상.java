package mission;

import java.util.HashMap;
import java.util.Map;

public class Pro_의상 {

    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution s = new Solution();

        System.out.println(s.solution(clothes));
    }


    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            Map<String, Integer> map = new HashMap<>();
            for (String[] clothe : clothes) {
                if(!map.containsKey(clothe[1])) map.put(clothe[1], 1);
                else map.put(clothe[1], map.get(clothe[1]) + 1);
            }
            int index = 0;
            int[] arr = new int[4];
            for (String s : map.keySet()) {
                arr[index] = map.get(s);
                index++;
            }


            for(int i= 0; i< arr.length -1; i ++){
                for(int j = i+1; j < arr.length; j++){
                    if(arr[j] == 1){
                        answer += arr[i];
                    }else {
                        answer += arr[i] * arr[j];
                    }
                    for(int k = arr.length-1; k>j ; k--){
                        if(arr[k] == 1){
                         answer += arr[i];
                        }else {
                            answer += arr[i] * arr[k];
                        }
                    }

                }
                answer += arr[i];
            }
            answer+= arr[3];
            return answer;
        }
    }
}
