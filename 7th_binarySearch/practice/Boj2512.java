public class BOJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int total = 0;

        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int yesan = Integer.parseInt(br.readLine());

        if(yesan >= total){
            System.out.println(max);
        } else{
            int left = 0;
            int right = max;

            long result = 0;
            while(left <= right){
                int mid = (left + right) / 2;
                long compare = 0;
                for(int i = 0; i < N; i++){
                    if(mid > arr[i]){
                        compare += arr[i];
                    } else{
                        compare += mid;
                    }
                }

                if(compare > yesan){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                    result = mid;
                }
            }

            System.out.println(result);
        }
    }
}
