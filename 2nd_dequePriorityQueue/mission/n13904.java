package mission;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class n13904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Subject> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new Subject(sc.nextInt(), sc.nextInt()));
        }

        int size=pq.stream().reduce((x,y)->x.getD()>y.getD()?x:y).get().getD();
        //가장 마지막 마감일 d만큼의 크기만큼 배열 할당
        int[] arr=new int[size];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = pq.peek().getW();
            int day = pq.peek().getD();
            if (arr[day-1] == 0) {
                sum += num;
                arr[day-1] = 1;
            }else{
                //마감일까지 과제를 해결할 수 있는 날이 있다면
                for (int j = day-1; j >= 0; j--) {
                    if(arr[j]==0) {
                        sum += num;
                        arr[j] = 1;
                        break;
                    }
                }
            }
            pq.poll();
        }
        System.out.println(sum);

    }
}

class Subject implements Comparable<Subject> {
    int d, w;

    public Subject(int d, int w) {
        this.d = d;
        this.w = w;
    }

    public int getD() {
        return d;
    }

    public int getW() {
        return w;
    }

    @Override
    public int compareTo(Subject s) {
        return s.getW()-this.w;
    }
}
