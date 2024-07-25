package mission;

import java.util.HashSet;
import java.util.Set;

public class Pro_폰켓몬 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3,1,2,3};

        System.out.println(s.solution(arr));
    }

    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num);
            }
            if(nums.length == 1) return answer = 1;
            if(set.size() >= nums.length/2){
                answer = nums.length/2;
            }else{
                answer = set.size();
            }


            return answer;
        }
    }
}
