package refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj19583_refactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String start = st.nextToken();
        String end = st.nextToken();
        String endStreaming = st.nextToken();
        int result = 0;
        Set<String> inSet = new HashSet<>();
        Set<String> outSet = new HashSet<>();

        String line;
        while((line = br.readLine()) != null && !line.isEmpty()){
             st = new StringTokenizer(line);
            String N = stringToInt(st.nextToken());
            String name = st.nextToken();
            if(start.compareTo(N) <= 0){
                inSet.add(name);
            }else if(end.compareTo(N) > 0 && endStreaming.compareTo(N) <= 0){
                outSet.add(name);
            }
        }
        for (String s : outSet) {
            if(inSet.contains(s)) result++;
        }
        System.out.println(result);
    }

    static String stringToInt(String str){
        String[] s = str.split(":");
        return s[0].concat(s[1]);
    }
}
