package mission;

import java.util.Scanner;

public class boj_1012 {
    static int p;
    static int[][] arr;
    static int[] row ={1, -1, 0, 0};
    static int[] col = {0, 0, -1, 1};

    public void dfs(int x, int y) {
        if (arr[x][y] == 1) {
            arr[x][y] = 0;
            //상하좌우
            for (int i = 0; i < row.length; i++) {
                int rdis = x+row[i];
                int cdis = y+col[i];
                //0보다 크고, 범위를 벗어나지 않은
                if(rdis>=0&&rdis<arr.length&&cdis>=0&&cdis<arr[rdis].length) {
                    dfs(rdis, cdis);
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int p = sc.nextInt();
            int q=sc.nextInt();
            int k = sc.nextInt();
            arr=new int[p][q];
            //배추 심기
            for(int j=0;j<k;j++) {
                arr[sc.nextInt()][sc.nextInt()]=1;
            }
            int answer = 0;
            //배추 탐색
            for (int x = 0; x < arr.length; x++) {
                for (int y = 0; y < arr[i].length; y++) {
                    if(arr[x][y]==1){
                        answer++;
                        new boj_1012().dfs(x,y);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
