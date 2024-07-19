package mission;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n1158 {
    public String solution(int n, int m) {
        Queue<Integer> q = new LinkedList<Integer>();
        StringBuilder answer = new StringBuilder();
        int p = 1;
        for (int i = 1; i <= n; i++) q.offer(i);

        while (!q.isEmpty()) {
                if(p==m) {
                    answer.append(q.poll());
                    p = 1;
                }
                else{
                    q.offer(q.poll());
                    p++;}
        }
        return answer.append("<").append(q.poll()).append(">").toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        a[0] = 1;
        n1158 t = new n1158();
        System.out.println(t.solution(n, m));


    }
}
