import java.io.*;
import java.util.*;

public class Boj1325{
	static int N, M, a, b;
	static ArrayList<Integer>[] list;
	static boolean visited[];
	static int depth[];
	static int max;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for(int i = 1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		depth = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(i);

			visited[i] = true;
			while(!queue.isEmpty()) {
				int n = queue.poll();
				for(int node : list[n]) {
					if(!visit[node]) {
						queue.add(node);
						visited[node]=true;
						depth[node]++;
					}
					
				}
			}

		}
		max=0;

		for(int count : depth) {
			max = Math.max(max, count);
		}
		StringBuilder sb=new StringBuilder();
		for(int i = 1; i <= N;i++) {
			if(depth[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);		
	}
}