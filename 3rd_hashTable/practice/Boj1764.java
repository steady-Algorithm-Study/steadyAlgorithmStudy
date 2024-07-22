package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Boj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();

        Function<String,Integer> fn = Integer::parseInt;
        StringBuilder sb = new StringBuilder();
        int n = fn.apply(st.nextToken());
        int m = fn.apply(st.nextToken());
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < n; i ++){
            set.add(br.readLine());
        }

        for(int i = 0  ; i < m ; i ++){
            String s = br.readLine();
            if(set.contains(s)) list.add(s);
        }

        Collections.sort(list);
        sb.append(list.size()+"\n");
        for (String s : list) {
            sb.append(s+"\n");
        }

        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);


    }
}
