package programmers.stack_queue;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char now = s.charAt(i);
            if (now == '(') {
                stack.push('(');
            } else if (now == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }
}
