package study;

import java.util.LinkedList;
import java.util.Scanner;

public class n1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q.addLast(i+1);
        }

        int answer = 0;
        for(int i = 0; i < m; i++){
            while(arr[i]!=q.peek()){
                int p = q.indexOf(arr[i]);
                int half = q.size()/2;

                //인덱스가 half+N일 경우 앞쪽으로 추가
                if(p>half) q.offerFirst(q.pollLast());
                //인덱스가 N일 경우 뒤쪽으로 추가
                else q.offerLast(q.poll());
                answer++;
            }
            q.poll();
        }
        System.out.println(answer);

    }
}
