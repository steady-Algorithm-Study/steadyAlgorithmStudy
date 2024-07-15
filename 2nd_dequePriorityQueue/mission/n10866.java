package study;

import java.util.LinkedList;
import java.util.Scanner;

public class n10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<String> deque = new LinkedList<>();
        for(int i=0;i<n;i++){
            String[] command = sc.nextLine().split(" ");
            switch (command[0]) {
                case "push_front":
                    deque.offerFirst(command[1]);
                    break;
                case "push_back":
                    deque.offerLast(command[1]);
                    break;
                case "pop_front":
                    if(deque.isEmpty()) System.out.println("-1");
                    else System.out.println(deque.pollFirst());
                    break;
                case "pop_back":
                    if(deque.isEmpty()) System.out.println("-1");
                    else System.out.println(deque.pollLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? "1" : "0");
                    break;
                case "front":
                    if(deque.isEmpty()) System.out.println("-1");
                    System.out.println(deque.peekFirst());
                    break;
                case "back":
                    if(deque.isEmpty()) System.out.println("-1");
                    System.out.println(deque.peekLast());
                    break;
            }
        }
    }
}
