import java.util.*;

/**
    폰켓몬
    시간복잡도: O(N)

    배열 -> 스트림 -> O(N)
    HashSet의 삽입 및 검색 작업까지 O(N)

    https://velog.io/@mooh2jj/Hash%EC%9D%98-%EA%B0%9C%EB%85%90-%EB%B0%8F-%EC%84%A4%EB%AA%85#%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-hash
 */
class Solution {
    public int solution(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().toArray();
        
        return nums.length / 2 >= arr.length ? arr.length : nums.length / 2;
    }
}