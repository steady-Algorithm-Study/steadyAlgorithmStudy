import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        list.add(Integer.parseInt(st.nextToken()));

        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(list.get(list.size() - 1) < num) {
                list.add(num);
            }
            else{
                int left = 0;
                int right = list.size() - 1;

                while(left <= right){
                    int mid = (left + right) / 2;

                    if(list.get(mid) > num){
                        right = mid - 1;
                    } else{
                        left = mid + 1;
                    }
                }

                list.set(left, num);
            }
        }

        for(int i : list){
            System.out.println(i);
        }
        System.out.println(N - list.size());
    }
}
