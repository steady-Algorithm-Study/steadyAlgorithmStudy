public class BOJ6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int min = 1;
        int max = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());

            min = Math.max(arr[i], min);
            max += arr[i];
        }

        int left = min;
        int right = max;

        int total = 0;
        int count = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            total = 0;
            count = 1;

            for(int i = 0; i < N; i++){
                total += arr[i];

                if(total > mid){
                    count++;
                    total = arr[i];
                }
            }

            if(count > M){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}