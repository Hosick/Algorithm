package baekjoon_step.step21_QueueAndDeque;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code_18258 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        MyQueue queue = new MyQueue();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                queue.push(st.nextToken());
                continue;
            } else if (command.equals("pop")) {
                bw.write(queue.pop() + "\n");
                continue;
            } else if (command.equals("size")) {
                bw.write(String.valueOf(queue.size()) + "\n");
                continue;
            } else if (command.equals("empty")) {
                bw.write(queue.empty() + "\n");
                continue;
            } else if (command.equals("front")) {
                bw.write(queue.front() + "\n");
                continue;
            } else if (command.equals("back")) {
                bw.write(queue.back() + "\n");
                continue;
            }
        }
        br.close();
        bw.close();
    }

    private static class MyQueue {
        ArrayList<String> queue = new ArrayList<>();
        int front = 0;
        int back = -1;

        /* noArgConstructor */
        private MyQueue() {
        }

        /* push */
        private void push(String num) {
            queue.add(num);
            ++back;
        }

        /* pop 후 출력, 큐가 비어있다면 -1 출력 */
        private String pop() {
            return front > back ? "-1" : queue.get(front++);
        }

        /* 큐의 사이즈 출력 */
        private int size() {
            return back - front + 1;
        }

        /* 큐가 비어있다면 1 아니라면 0 출력 */
        private String empty() {
            return front > back ? "1" : "0";
        }

        /* 큐의 front 출력 */
        private String front() {
            return front > back ? "-1" : queue.get(front);
        }

        /* 큐의 back 출력 */
        private String back() {
            return front > back ? "-1" : queue.get(back);
        }
    }
}
