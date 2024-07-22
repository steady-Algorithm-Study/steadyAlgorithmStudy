package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int same = 0;
        String[] s = br.readLine().split(" ");
        Set<Integer> set = new HashSet<>();

        for (String string : s) {
            set.add(Integer.parseInt(string));
        }

        String[] s2 = br.readLine().split(" ");
        for (String string : s2) {
            if(!set.add(Integer.parseInt(string))){
                same++;
            }
        }
        System.out.println(set.size()-same);

    }
}
