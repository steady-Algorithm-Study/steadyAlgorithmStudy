package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Double size = 0.0;
        Map<String, Double> map = new HashMap<>();
        while((line = br.readLine()) != null && !line.isEmpty()){
            if(map.get(line) == null){
             map.put(line, 1.0);
            }else{
                map.put(line, map.get(line)+1);
            }
            size++;
        }

        List<String> list = new ArrayList<>();

        for (String s : map.keySet()) {

            String format = String.format("%.4f", map.get(s) / size * 100);
            list.add(s + " " + format);
        }


        list.sort(String::compareTo);
        for (String s : list) {
            System.out.println(s);
        }


    }
}
