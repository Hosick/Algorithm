package baekjoon.baekjoon_step.step21_QueueAndDeque;

import java.io.*;
import java.util.StringTokenizer;

public class Code_10866 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        MyDeque deque = new MyDeque();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                deque.push_front(st.nextToken());
                continue;
            } else if (command.equals("push_back")) {
                deque.push_back(st.nextToken());
                continue;
            } else if (command.equals("pop_front")) {
                bw.write(deque.pop_front() + "\n");
                continue;
            } else if (command.equals("pop_back")) {
                bw.write(deque.pop_back() + "\n");
                continue;
            } else if (command.equals("size")) {
                bw.write(deque.size() + "\n");
                continue;
            } else if (command.equals("empty")) {
                bw.write(deque.empty() + "\n");
                continue;
            } else if (command.equals("front")) {
                bw.write(deque.front() + "\n");
                continue;
            } else if (command.equals("back")) {
                bw.write(deque.back() + "\n");
                continue;
            }
        }
        br.close();
        bw.close();
    }

    /* Deque 클래스 구현  */
    private static class MyDeque {
        String[] deque = new String[20001];
        int front = 10001;
        int back = 10000;

        /* noArgConstructor */
        private MyDeque() {
        }

        /* front에 push */
        private void push_front(String x) {
            deque[--front] = x;
        }

        /* back에 push */
        private void push_back(String x) {
            deque[++back] = x;
        }

        /* front에서 pop */
        private String pop_front() {
            if (front > back) {
                return "-1";
            } else {
                return deque[front++];
            }
        }

        /* back에서 pop */
        private String pop_back() {
            if (front > back) {
                return "-1";
            } else {
                return deque[back--];
            }
        }

        /* deque의 사이즈 return */
        private String size() {
            return String.valueOf(back - front + 1);
        }

        /* deque가 비어있다면 1, 아니라면 0 return */
        private String empty() {
            return front > back ? "1" : "0";
        }

        /* front의 정수 return, 없다면 -1 return  */
        private String front() {
            return front > back ? "-1" : deque[front];
        }

        /* back의 정수 return, 없다면 -1 return */
        private String back() {
            return front > back ? "-1" : deque[back];
        }
    }
}