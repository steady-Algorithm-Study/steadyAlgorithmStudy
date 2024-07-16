import java.util.PriorityQueue;
import java.util.Collections;
class Boj10866{
    static PriorityQueue<String> pq
    static StringTokenizer st;
    public static void main(String[]args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Test_case = Integer.parseInt(br.readLine());
        for(it i=0; i<Test_case;i++) {
            String cmd = br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            /*switch~case문*/
//        switch(변수){
//            case 변수: // 변수와 값이 일치하면 해당 case문 작동
//                //실행문
//                break;
//            default: // 변수와 값이 불일치하면 default 샐행문 작동
//                //실행문
//                break;
//        }
//        break문 없으면 바로 다음 case문 안의 실행문 실행

            switch (cmd) {
                case "push_front":
                    pq = new PriorityQueue<>();
                    //공백단위로 다름 숫자를 입력받고
                    int num = Integer.parseInt(st.nextToken());
                    //우선순위 큐에 삽입
                    pq.offer(num);
                    break;

                case "push_back":
                    pq = new PriorityQueue<>(Collections.reverseOrder());
                    int num = Integer.parseInt(st.nextToken());
                    pq.offer(num);
                    break;

                case "pop_front":
                    pq = new PriorityQueue<>();
                    if(!pq.isEmpty()) {
                        pq.poll();
                    }else   return -1;
                    break;

                case "pop_back":
                    pq = new PriorityQueue<>(Collection.reverseOrder());
                    if(!pq.isEmpty()){
                        pq.poll();
                    }else return -1;
                    break;

                case "size":
                    pq = new PriorityQueue<>();
                    System.out.println(pq.size());
                    break;

                case "empty":
                    pq = new PriorityQueue<>();
                    if(pq.isEmpty())    return 1;
                    else return 0;
                    break;

                case "front":
                    pq = new PriorityQueue<>();
                    if(!pq.isEmpty()){
                        pq.pop();
                    }else   return -1;
                    break;

                case "back":
                    pq = new PriorityQueue<>(Collection.reverseOrder());
                    if(!pq.isEmpty())
                        pq.pop();
                    else    return -1;
                    break;

            }
        }
    }
}