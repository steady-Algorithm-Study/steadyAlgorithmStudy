import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj23294 {
    static int[] sizeArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sizeArr = new int[N + 1];

        Deque<Integer> backDeque = new LinkedList<>();
        Deque<Integer> frontDeque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sizeArr[i] = Integer.parseInt(st.nextToken());
        }

        // 사용 중인 캐시 크기
        int cacheSize = 0;
        int pointer = 0;

        while (Q --> 0) {
            st = new StringTokenizer(br.readLine());

            String cur = st.nextToken();

            switch (cur) {
                case "B":
                    if (backDeque.isEmpty()) continue;
                    frontDeque.addFirst(pointer);
                    cacheSize += sizeArr[pointer];
                    pointer = backDeque.pollLast();
                    cacheSize -= sizeArr[pointer];
                    break;
                case "F":
                    if (frontDeque.isEmpty()) continue;
                    backDeque.addLast(pointer);
                    cacheSize += sizeArr[pointer];
                    pointer = frontDeque.pollFirst();
                    cacheSize -= sizeArr[pointer];
                    break;
                case "A":
                    while (!frontDeque.isEmpty()) {
                        cacheSize -= sizeArr[frontDeque.pollFirst()];
                    }
                    if (pointer != 0) backDeque.addLast(pointer);
                    pointer = Integer.parseInt(st.nextToken());
                    cacheSize += sizeArr[pointer];
                    while (cacheSize > C && !backDeque.isEmpty()) {
                        cacheSize -= sizeArr[backDeque.pollFirst()];
                    }
                    break;
                case "C":
                    Deque<Integer> tmp = new LinkedList<>();
                    int pre;
                    if (backDeque.isEmpty()) {
                        continue;
                    } else {
                        pre = backDeque.pollLast();
                        tmp.addFirst(pre);
                    }
                    while (!backDeque.isEmpty()) {
                        int t = backDeque.pollLast();
                        if (pre == t) {
                            cacheSize -= sizeArr[t];
                            continue;
                        }
                        tmp.addFirst(t);
                        pre = t;
                    }
                    backDeque = tmp;
                    break;
            }
        }

        bw.write(pointer + "\n");
        if (backDeque.isEmpty()) {
            bw.write(-1+"\n");
        } else {
            while (!backDeque.isEmpty()) {
                bw.write(backDeque.pollLast() + " ");
            }
            bw.write("\n");
        }

        if (frontDeque.isEmpty()) {
            bw.write(-1+"\n");
        } else {
            while (!frontDeque.isEmpty()) {
                bw.write(frontDeque.pollFirst() + " ");
            }
        }

        bw.flush();
    }
}