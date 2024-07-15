package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Pro_Process {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 9, 1, 1, 1}	;
//        int[] arr = {2,1,3,2}	;
        int[] arr = {1,1,3,2,1}	;
        int lo = 0;
        System.out.println(solution(arr,lo));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int priority : priorities) {
            pq.offer(priority);
        }
        while(!pq.isEmpty()) {
            for(int i = 0 ; i < priorities.length ; i ++){

                if(pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    if(i == location) return answer;
                }
            }
        }
        return answer;
    }
}


