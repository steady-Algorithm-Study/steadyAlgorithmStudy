package study;

import java.util.PriorityQueue;
import java.util.Scanner;

public class n15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            minHeap.add(sc.nextInt());
        }
        for(int i=0;i<m;i++){
            int sum=minHeap.poll()+minHeap.poll();
            minHeap.offer(sum);
            minHeap.offer(sum);
        }
        int answer = 0;

        while(!minHeap.isEmpty()){
            answer+=minHeap.poll();
        }
        System.out.println(answer);

    }
}
