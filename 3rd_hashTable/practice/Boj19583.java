package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] arr = new int[3];
        int chk = 0;
        for (String string : s) {
            String[] s1 = string.split(":");
            arr[chk] = Integer.parseInt(s1[0].concat(s1[1]));
            chk++;
        }
        int result = 0;
        Set<String> set = new HashSet<>();
        String line;
        while((line = br.readLine()) != null && !line.isEmpty()){
            StringTokenizer st = new StringTokenizer(line);
            int N = stringToInt(st.nextToken());
            String name = st.nextToken();
            if(arr[0] >= N){
                set.add(name);
            }else if(arr[1] <= N &&arr[2] >= N && N <= 2359){
                if(set.remove(name)) {
                    result++;
                }
            }


        }
        System.out.println(result);
    }

    static int stringToInt(String str){
        String[] s = str.split(":");
        return Integer.parseInt(s[0].concat(s[1]));
    }
}
