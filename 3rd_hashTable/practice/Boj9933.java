package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj9933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i= 0; i < n ; i ++){
            list.add(br.readLine());
        }
        for(int i = 0 ; i < n ; i ++){
            StringBuffer sb = new StringBuffer(list.get(i));
            if(list.contains(sb.reverse().toString())){
                System.out.println(list.get(i).length() + " " + list.get(i).charAt((list.get(i).length()-1) /2));
                break;
            }
        }

    }
}

