package baekjoon_step.step20_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        MyStack stack = new MyStack();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 입력 받은 명령어

            if (command.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            } else if (command.equals("pop")) {
                stack.pop();
                continue;
            } else if (command.equals("size")) {
                stack.size();
                continue;
            } else if (command.equals("empty")) {
                stack.empty();
                continue;
            } else if (command.equals("top")) {
                stack.top();
                continue;
            }
        }
    }

    /* Stack 클래스 구현 */
    public static class MyStack {
        ArrayList<Integer> stack = new ArrayList();

        public MyStack() {
        }

        /* 스택에 숫자 push */
        public void push(int n) {
            stack.add(n);
        }

        /* 스택에서 최상위 인덱스 pop, 없다면 -1 출력 */
        public void pop() {
            if (stack.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
            }
        }

        /* 스택 사이즈 출력*/
        public void size() {
            System.out.println(stack.size());
        }

        /* 스택이 비어있다면 1, 아니라면 0 출력 */
        public void empty() {
            int empty = (stack.isEmpty()) ? 1 : 0;
            System.out.println(empty);
        }

        /* 스택에서 최상위 인덱스 출력, 없다면 -1 출력 */
        public void top() {
            System.out.println((stack.isEmpty()) ? -1 : stack.get(stack.size() - 1));
        }
    }
}