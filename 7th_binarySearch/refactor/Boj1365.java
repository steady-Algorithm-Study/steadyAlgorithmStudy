package refactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(arr[0]);
        for(int i = 1; i < N; i++){
            int num = arr[i];

            if(num > resultList.get(resultList.size()-1)){
                resultList.add(num);
            }else{
                int start = 0;
                int end = resultList.size()-1;
                while( start < end){
                    int half = (start+end) / 2;

                    if(resultList.get(half) < num){
                        start = half + 1;
                    }else{
                        end = half;
                    }
                }
                resultList.set(end, num);
            }
        }


        System.out.println(N - resultList.size());


    }
}
