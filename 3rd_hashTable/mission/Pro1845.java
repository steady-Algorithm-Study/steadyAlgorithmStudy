import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().toArray();
        
        return nums.length / 2 >= arr.length ? arr.length : nums.length / 2;
    }
}