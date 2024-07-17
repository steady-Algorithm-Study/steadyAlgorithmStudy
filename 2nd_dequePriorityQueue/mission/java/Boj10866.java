
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.io.IOException;

class Boj10866{

    public static void main(String[]args)throws IOException{
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Test_Case = Integer.parseInt(br.readLine());

        for(int i=0; i<Test_Case;i++) {
            String[] cmd = br.readLine().split(" ");    // command를 공백을 띄어서 숫자를 ArrayDeque에 담기 용이하ㅔ함

            switch (cmd[0]) {

                case "push_front":
                    dq.addFirst(Integer.parseInt(cmd[1]));
                    break;

                case "push_back":
                    dq.addLast(Integer.parseInt(cmd[1]));
                    break;

                case "pop_front":
                    if (!dq.isEmpty())
                        sb.append(dq.pollFirst()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                case "pop_back":
                    if (!dq.isEmpty())
                        sb.append(dq.pollLast()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                case "size":
                    sb.append(dq.size()).append("\n");
                    break;

                case "empty":
                    sb.append(dq.isEmpty()).append("\n");
                    //isEmpty가 참이면 true, 아니면 false반환
                    break;

                case "front":
                    if (!dq.isEmpty())
                        sb.append(dq.peekFirst()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                case "back":
                    if (!dq.isEmpty())
                        sb.append(dq.peekLast()).append("\n");
                    else
                        sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }// end of main
}// end of class

//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//
//
//class Boj10866{
//    static ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
//    static String num;
//
//    public static void main(String[]args)throws IOException {
//        StringBuilder sb = new StringBuilder();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int Test_case = Integer.parseInt(br.readLine());
//
//        for(int i=0; i<Test_case;i++) {
//            String[] cmd = br.readLine().split(" ");
//            /*switch~case문*/
////        switch(변수){
////            case 변수: // 변수와 값이 일치하면 해당 case문 작동
////                //실행문
////                break;
////            default: // 변수와 값이 불일치하면 default 샐행문 작동
////                //실행문
////                break;
////        }
////        break문 없으면 바로 다음 case문 안의 실행문 실행
//
//            switch (cmd[0]) {
//                case "push_front":
//                    dq.addFirst(Integer.parseInt(cmd[1]));
//
//                    break;
//
//                case "push_back":
//                    dq.addLast(Integer.parseInt(cmd[1]));
//                    break;
//
//                case "pop_front":
//                    if(!dq.isEmpty()) {
//                        sb.append(dq.pollFirst()).append("\n");
//                    }else sb.append(-1).append("\n");
//                    break;
//
//                case "pop_back":
//                    if(!dq.isEmpty()){
//                        sb.append(dq.pollLast()).append("\n");
//                    }else sb.append(-1).append("\n");
//                    break;
//
//                case "size":
//                    sb.append(dq.size()).append("\n");
//                    break;
//
//                case "empty":
//                    if(dq.isEmpty()) sb.append(1).append("\n");
//                    else sb.append(0).append("\n");
//                    break;
//
//                case "front":
//                    if(!dq.isEmpty()){
//                        sb.append(dq.peekFirst()).append("\n");
//                    } else sb.append(-1).append("\n");
//                    break;
//
//                case "back":
//                    if(!dq.isEmpty())
//                        sb.append(dq.peekLast()).append("\n");
//                    else sb.append(-1).append("\n");
//                    break;
//
//            }
//        }
//        System.out.println(sb);
//    }// end of main
//}   // end of clas