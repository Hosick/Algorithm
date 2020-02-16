package baekjoon_step.step20_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Code_4949 {
    public static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            stack = new Stack();
            String yn = "yes";
            String line = br.readLine();
            if (line.equals(".")) break;    //  . 을 입력하면 종료

            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == '(')  //  ( push
                    stack.push('(');
                else if (line.charAt(i) == '[') // [ push
                    stack.push('[');
                else if (line.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(')  //  ()일 때
                    stack.pop();
                else if (line.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[')  //  []일 때
                    stack.pop();
                else if (line.charAt(i) == ')' || line.charAt(i) == ']') {
                    yn = "no";
                    break;
                }
            }

            System.out.println(stack.isEmpty() ? yn : "no"); // 스택이 비어있아야만 yes
        }
        br.close();
    }
}