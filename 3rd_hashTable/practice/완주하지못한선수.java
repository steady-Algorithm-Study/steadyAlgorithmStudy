package practice;

import java.util.*;
class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int n = completion.length;

        for(int i = 0; i < n; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[n];
    }
}

/*
테스트 1 〉	통과 (0.19ms, 74.1MB)
테스트 2 〉	통과 (0.33ms, 77.7MB)
테스트 3 〉	통과 (1.75ms, 78.4MB)
테스트 4 〉	통과 (2.82ms, 74.9MB)
테스트 5 〉	통과 (4.12ms, 77.1MB)
테스트 6 〉	통과 (0.33ms, 79MB)
테스트 7 〉	통과 (0.26ms, 73.5MB)
효율성  테스트
테스트 1 〉	통과 (121.16ms, 81.9MB)
테스트 2 〉	통과 (205.37ms, 87.8MB)
테스트 3 〉	통과 (271.98ms, 94.7MB)
테스트 4 〉	통과 (343.76ms, 95.3MB)
테스트 5 〉	통과 (349.38ms, 97.1MB)
 */