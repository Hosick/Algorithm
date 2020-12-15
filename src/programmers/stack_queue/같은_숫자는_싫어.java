package programmers.stack_queue;

import java.util.Stack;

class 같은_숫자는_싫어 {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int v : arr) {
            if (stack.isEmpty() || stack.peek() != v)
                stack.push(v);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}