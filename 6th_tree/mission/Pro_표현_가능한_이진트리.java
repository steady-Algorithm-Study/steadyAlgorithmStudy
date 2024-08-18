package mission;

public class Pro_표현_가능한_이진트리 {

    public static void main(String[] args) {
        long[] numbers = {7L,42L,5L};
        int[] result = solution(numbers);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    static int[] solution(long[] numbers){
        int[] answer = {};
        for(int i = 0; i < numbers.length; i++){
            String str = Long.toString(numbers[i], 2);
        }
        return answer;
    }

}

