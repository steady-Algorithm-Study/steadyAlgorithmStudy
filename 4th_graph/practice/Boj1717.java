package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        int M = Integer.parseInt(st.nextToken());
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int chk = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(chk == 0){
                union(a,b);
            }else if(chk == 1){
                System.out.println(check(a,b));
            }
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }

    static int find(int n){
        if(parent[n] == n){
            return n;
        }else{
            return parent[n] = find(parent[n]);
        }
    }

    static String check(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b)return "YES";
        else return "NO";
    }
}
