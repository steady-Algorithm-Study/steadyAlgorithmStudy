package study;

import java.util.LinkedList;
import java.util.Scanner;

public class n2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        String answer = "";
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            int num = i + 1;
            if (num > 0) {
                for(int j=0;j<num;j++){
                    queue.offer(queue.poll());
                }answer+=queue.poll();
            }else {
                for (int j = num; j < 0; j++) {
                    queue.offerLast(queue.pollLast());
                }answer+=queue.pollLast();
            }
        }
        System.out.println(answer);

    }
}
