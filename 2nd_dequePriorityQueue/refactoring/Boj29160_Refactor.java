package refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Boj29160_Refactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String ,Integer> fun = Integer::parseInt;

        int n = fun.apply(st.nextToken());
        int k = fun.apply(st.nextToken());
        PriorityQueue<Integer>[] pqArr = new PriorityQueue[12];
        int sum = 0;
        for (int i = 1; i < pqArr.length; i++) {
            pqArr[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            int index = fun.apply(st.nextToken());
            int value = fun.apply(st.nextToken());
            pqArr[index].offer(value);
        }


        for (int j = 0; j < k; j++) {
            sum = 0 ;
            for(int i = 1 ; i  < pqArr.length ; i ++) {
                if (!pqArr[i].isEmpty()) {
                    int poll = pqArr[i].poll() - 1;
                    pqArr[i].offer(poll);
                    sum += (Math.max(pqArr[i].peek(), 0));
                }
            }

        }

        System.out.println(sum);
    }
}


